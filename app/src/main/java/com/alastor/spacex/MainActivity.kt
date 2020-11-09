package com.alastor.spacex

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.alastor.spacex.di.main.MainComponent
import com.alastor.spacex.extensions.findNavControllerWithNavHost
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private var mainComponent: MainComponent? = null
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = findNavControllerWithNavHost(supportFragmentManager, R.id.main_nav_container)
        implementBottomView()
    }

    public fun mainComponent(): MainComponent {
        if (mainComponent == null) {
            mainComponent = (application as MainApplication).appComponent
                .mainComponent()
                .create()
        }
        return mainComponent as MainComponent
    }

    private fun inject() {
        mainComponent().inject(this)
    }

    private fun implementBottomView() {
        findViewById<BottomNavigationView>(R.id.bottom_nav_view)
            .setupWithNavController(navController)
        val appBarConfiguration =
            AppBarConfiguration(setOf(R.id.launchesFragment, R.id.launchesCompleteFragment))
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onDestroy() {
        super.onDestroy()
        mainComponent = null;
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}