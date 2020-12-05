package com.alastor.spacex.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.FragmentScoped
import java.text.SimpleDateFormat
import java.util.*

@Module
@InstallIn(FragmentComponent::class)
object DateModule {

    @Provides
    fun provideSimpleDateFormat(): SimpleDateFormat {
        return  SimpleDateFormat("dd.mm.yyyy HH:mm", Locale.US)
    }
}