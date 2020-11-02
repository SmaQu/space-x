package com.alastor.spacex

import android.app.Application
import com.alastor.spacex.di.AppComponent
import com.alastor.spacex.di.DaggerAppComponent
import com.alastor.spacex.di.main.MainComponent
import com.alastor.spacex.viewmodel.ViewModelProviderFactory
import javax.inject.Inject

class MainApplication: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.factory().create(this)

    }

    fun createMainComponent(): MainComponent {
        return appComponent.mainComponent().create()
    }

}