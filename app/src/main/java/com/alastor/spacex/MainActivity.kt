package com.alastor.spacex

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.alastor.spacex.extensions.findNavControllerWithNavHost
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = findNavControllerWithNavHost(supportFragmentManager, R.id.main_nav_container)
        implementBottomView()
    }

    private fun implementBottomView() {
        findViewById<BottomNavigationView>(R.id.bottom_nav_view)
            .setupWithNavController(navController)
        val appBarConfiguration =
            AppBarConfiguration(setOf(R.id.launchesFragment, R.id.launchesCompleteFragment))
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}