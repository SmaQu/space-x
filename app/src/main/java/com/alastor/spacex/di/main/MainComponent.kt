package com.alastor.spacex.di.main

import com.alastor.spacex.MainActivity
import com.alastor.spacex.di.appmodule.network.CapsuleServiceModule
import com.alastor.spacex.di.main.annotations.MainScope
import com.alastor.spacex.di.main.modules.MainModule
import com.alastor.spacex.di.main.modules.MainViewModelModule
import com.alastor.spacex.di.main.modules.ViewModelFactoryModule
import com.alastor.spacex.ui.MainFragment
import dagger.Subcomponent

@MainScope
@Subcomponent(
    modules = [
        MainModule::class,
        MainViewModelModule::class
    ]
)
interface MainComponent {

    @Subcomponent.Factory
    interface Factory {

        fun create(): MainComponent
    }

    fun inject(mainActivity: MainActivity)

    fun inject(mainFragment: MainFragment)

}