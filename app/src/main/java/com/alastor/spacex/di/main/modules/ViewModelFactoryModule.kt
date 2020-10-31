package com.alastor.spacex.di.main.modules

import androidx.lifecycle.ViewModelProvider
import com.alastor.spacex.di.main.annotations.MainScope
import com.alastor.spacex.viewmodel.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {

    @MainScope
    @Binds
    abstract fun bindsViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory
}