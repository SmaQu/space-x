package com.alastor.spacex.di

import com.alastor.spacex.MainApplication
import com.alastor.spacex.di.main.MainComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        SubComponentModule::class
    ]
)
interface AppComponent {

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance application: MainApplication): AppComponent
    }

    fun mainComponent(): MainComponent.Factory
}
