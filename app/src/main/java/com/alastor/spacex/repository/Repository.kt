package com.alastor.spacex.repository

import com.alastor.spacex.model.Capsule
import com.alastor.spacex.model.UpcomingLaunch
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(private val spaceXService: SpaceXService) {

    fun getUpComingLaunches() : Single<List<UpcomingLaunch>> {
        return spaceXService.getUpcomingLaunches();
    }
}