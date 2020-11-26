package com.alastor.spacex.di

import com.alastor.spacex.repository.SpaceXService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object SpaceXServiceModule {

    @Singleton
    @Provides
    fun provideCapsuleService(retrofit: Retrofit): SpaceXService {
        return retrofit.create(SpaceXService::class.java)
    }
}