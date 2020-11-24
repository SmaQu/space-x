package com.alastor.spacex.di.main

import com.alastor.spacex.MainActivity
import com.alastor.spacex.di.main.annotations.MainScope
import com.alastor.spacex.di.main.modules.MainModule
import com.alastor.spacex.di.main.modules.MainViewModelModule
import com.alastor.spacex.di.main.modules.ViewModelFactoryModule
import com.alastor.spacex.ui.upcominglaunches.UpComingLaunchesFragment
import dagger.Subcomponent

@MainScope
@Subcomponent(
    modules = [
        MainModule::class,
        ViewModelFactoryModule::class,
        MainViewModelModule::class
    ]
)
interface MainComponent {

    @Subcomponent.Factory
    interface Factory {

        fun create(): MainComponent
    }

    fun inject(mainActivity: MainActivity)

    fun inject(upComingLaunchesFragment: UpComingLaunchesFragment)

}