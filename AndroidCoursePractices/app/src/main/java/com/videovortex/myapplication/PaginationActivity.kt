package com.videovortex.myapplication

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.videovortex.myapplication.FragmentsPagination.FirstPageFragment
import com.videovortex.myapplication.FragmentsPagination.SecondPageFragment
import com.videovortex.myapplication.FragmentsPagination.ThirdPageFragment

class PaginationActivity : AppCompatActivity() {

    lateinit var viewPager : ViewPager2
    lateinit var tabLayout : TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paginator)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

         viewPager = findViewById(R.id.viewPager)
         tabLayout = findViewById(R.id.tabLayout)

        val fragmentList = listOf(FirstPageFragment(), SecondPageFragment(), ThirdPageFragment())

        val pagerAdapter = PginationAdapter(this, fragmentList)
        viewPager.adapter = pagerAdapter

        // Conecta el ViewPager2 y el TabLayout
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            // Asigna títulos a las pestañas
            tab.text = when (position) {
                0 -> "Dados"
                1 -> "Tab 2"
                2 -> "Tab 3"
                else -> "Tab Desconocida"
            }
        }.attach()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                // Manejar el clic en la flecha de "Atrás" aquí
                onBackPressedDispatcher.onBackPressed() // Esto es opcional, puedes personalizarlo según tus necesidades
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

}
