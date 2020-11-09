package com.alastor.spacex.di.appmodule.network

import com.alastor.spacex.repository.SpaceXService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
object SpaceXServiceModule {

    @JvmStatic
    @Singleton
    @Provides
    fun provideCapsuleService(retrofit: Retrofit): SpaceXService {
        return retrofit.create(SpaceXService::class.java)
    }
}