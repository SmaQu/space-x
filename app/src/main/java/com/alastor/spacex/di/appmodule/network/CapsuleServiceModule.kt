package com.alastor.spacex.di.appmodule.network

import com.alastor.spacex.di.main.annotations.MainScope
import com.alastor.spacex.network.CapsuleService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
object CapsuleServiceModule {

    @JvmStatic
    @Singleton
    @Provides
    fun provideCapsuleService(retrofit: Retrofit): CapsuleService {
        return retrofit.create(CapsuleService::class.java)
    }
}