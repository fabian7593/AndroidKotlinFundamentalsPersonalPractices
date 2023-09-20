
package com.videovortex.myapplication

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.navigation.NavigationView
import com.videovortex.myapplication.FragmentsLateralMenu.LateralMenuFirstFragment
import com.videovortex.myapplication.FragmentsLateralMenu.LateralMenuSecondFragment
import com.videovortex.myapplication.FragmentsLateralMenu.SecondPageNavigationFirstFragment
import com.videovortex.myapplication.FragmentsLateralMenu.SecondPageNavigationSecondFragment

class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView

    //TODO esta es la logica para saber cual es el fragmento actual, y para modificar el backPressed manualmente
    private var currentFragment: Fragment? = null

    //TODO la logica de toogle para cambiar el arrow en cualquier pantalla
    private var toogle: ActionBarDrawerToggle? = null

    fun getToggle() : ActionBarDrawerToggle?{
        return toogle
    }

    //TODO este set de current fragment se setea en cada uno de los fragmentos en el createview
    // Método público para establecer el fragmento actual
    fun setCurrentFragment(fragment: Fragment) {
        currentFragment = fragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.navigation_view)

        // Configurar el ActionBarDrawerToggle para abrir/cerrar el menú lateral
        toogle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )

        //TODO pone el hamburger de drawer menu lateral izquierdo como una flecha de back
        toogle?.isDrawerIndicatorEnabled = true

        drawerLayout.addDrawerListener(toogle!!)
        toogle?.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        // Configurar el listener para los elementos del menú lateral
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_camera -> {
                    changeFragment(LateralMenuFirstFragment())
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.nav_gallery -> {
                    changeFragment(LateralMenuSecondFragment(), "gallery_frag")
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                else -> false
            }
        }

        changeFragment(LateralMenuFirstFragment())

    }

    fun changeFragment(newFragment :Fragment, backStack: String = ""){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, newFragment)
        transaction.addToBackStack(if (backStack == "") null else backStack)
        transaction.commit()

        //TODO setea el current fragment
        currentFragment = newFragment
        toogle?.isDrawerIndicatorEnabled = true
    }

    //TODO Esto maneja la logica de menu lateral izquierdo, par que funcione de distintas maneras en distitnos fragmentos
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {

            when (currentFragment) {
                is SecondPageNavigationFirstFragment -> {
                    onBackPressedDispatcher.onBackPressed()
                    return true
                }
                is SecondPageNavigationSecondFragment -> {
                    supportFragmentManager.popBackStack("gallery_frag", 0)
                    return true
                }
                // Agrega más fragmentos y casos según sea necesario
                else -> {
                    // Comportamiento predeterminado o manejo de otros elementos de menú
                    if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        drawerLayout.closeDrawer(GravityCompat.START)
                    } else{
                        drawerLayout.openDrawer(GravityCompat.START)
                    }
                    return true
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

    //TODO esto maneja la logica del back press de abajo
    override fun onBackPressed() {

        when (currentFragment) {
            is SecondPageNavigationFirstFragment -> {
                onBackPressedDispatcher.onBackPressed()
            }
            is SecondPageNavigationSecondFragment -> {
                supportFragmentManager.popBackStack("gallery_frag", 0)
            }
            // Agrega más fragmentos y casos según sea necesario
            else -> {
                // Comportamiento predeterminado o manejo de otros elementos de menú
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START)
                } else{
                    drawerLayout.openDrawer(GravityCompat.START)
                }
            }
        }
    }
}
