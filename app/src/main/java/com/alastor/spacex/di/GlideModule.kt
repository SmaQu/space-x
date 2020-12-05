package com.alastor.spacex.di

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object GlideModule {

    @Singleton
    @Provides
    fun provideGlideInstance(@ApplicationContext appContext: Context): RequestManager {
        return Glide.with(appContext)
    }

}