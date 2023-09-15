package com.videovortex.myapplication

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.videovortex.myapplication.databinding.ActivityDrawerCompleteExampleBinding

class DrawerCompleteExample : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityDrawerCompleteExampleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDrawerCompleteExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarDrawerCompleteExample.toolbar)

        binding.appBarDrawerCompleteExample.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController =
            findNavController(R.id.nav_host_fragment_content_drawer_complete_example)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.drawer_complete_example, menu)
        return true
    }



    override fun onSupportNavigateUp(): Boolean {
        val navController =
            findNavController(R.id.nav_host_fragment_content_drawer_complete_example)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                // Personaliza el comportamiento del botón de retroceso aquí
                //LOGIC TO GO BACK FROM TAB BAR
                val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_drawer_complete_example)
                val navController = navHostFragment?.findNavController()

                val currentDestination = navController?.currentDestination
                val currentFragmentClassName = currentDestination?.displayName // Nombre de la clase del fragmento actual

                if (currentFragmentClassName == "com.videovortex.myapplication:id/secondNavigationDrawerFragment") {
                    navController.popBackStack(R.id.nav_home,false)
                    return true
                } else {
                    return super.onOptionsItemSelected(item)
                }
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}