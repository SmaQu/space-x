package com.alastor.spacex.extensions

import android.app.Activity
import androidx.annotation.IdRes
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.fragment.NavHostFragment

fun Activity.findNavControllerWithNavHost(fragment: FragmentManager, @IdRes viewId: Int)
        : NavController {
    return (fragment.findFragmentById(viewId) as NavHostFragment).navController
}
