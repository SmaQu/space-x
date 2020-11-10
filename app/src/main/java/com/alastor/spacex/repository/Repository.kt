package com.alastor.spacex.repository

import com.alastor.spacex.model.pagination.Pagination
import com.alastor.spacex.model.pagination.QueryBody
import com.alastor.spacex.model.UpcomingLaunch
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(private val spaceXService: SpaceXService) {

    fun getUpComingLaunches() : Single<List<UpcomingLaunch>> {
        return spaceXService.getUpcomingLaunches();
    }

    fun getTestPagination(queryBody: QueryBody) : Single<Pagination<List<UpcomingLaunch>>> {
        return spaceXService.getLaunchesQuery(queryBody)
    }
}