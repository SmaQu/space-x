package com.alastor.spacex.di.main.modules

import androidx.lifecycle.ViewModel
import com.alastor.spacex.MainViewModel
import com.alastor.spacex.di.main.annotations.MainScope
import com.alastor.spacex.di.main.annotations.MainViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainViewModelModule {

    @MainScope
    @Binds
    @IntoMap
    @MainViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel
}