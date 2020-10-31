package com.alastor.spacex.di

import com.alastor.spacex.di.main.MainComponent
import dagger.Module

@Module(subcomponents = [MainComponent::class])
object SubComponentModule