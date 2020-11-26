package com.alastor.spacex

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.alastor.spacex.extensions.findNavControllerWithNavHost
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        navController =
            findNavControllerWithNavHost(supportFragmentManager, R.id.main_nav_container)

        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.launchesFragment, R.id.launchesCompleteFragment),
            drawer_layout
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        setupBottomView()
        setupDrawerLayout()
    }

    private fun setupBottomView() {
        bottom_nav_view.setupWithNavController(navController)
    }

    private fun setupDrawerLayout() {
        drawer_nav_view.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}