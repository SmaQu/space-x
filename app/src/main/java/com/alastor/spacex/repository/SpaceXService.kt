package com.alastor.spacex.repository

import com.alastor.spacex.model.*
import com.alastor.spacex.model.pagination.Pagination
import com.alastor.spacex.model.pagination.QueryBody
import io.reactivex.Flowable
import io.reactivex.Single
import retrofit2.http.*
import javax.inject.Singleton

@Singleton
interface SpaceXService {

    @GET("capsules")
    fun getCapsules(): Flowable<List<Capsule>>

    @GET("capsules/{id}")
    fun getCapsule(@Path("id") id: Long): Single<Capsule>

    @GET("company")
    fun getCompanyInfo(): Single<Company>

    @GET("cores")
    fun getCores(): Single<List<Core>>

    @GET("cores/{id}")
    fun getCore(@Path("id") id: Long): Single<Core>

    @GET("crew")
    fun getCrews(): Single<List<Crew>>

    @GET("crew/{id}")
    fun getCrew(@Path("id") id: Long): Single<Crew>

    @GET("dragons")
    fun getDragons(): Single<List<Dragon>>

    @GET("dragons/{id}")
    fun getDragon(@Path("id") id: Long): Single<Dragon>

    @GET("landpads")
    fun getLandpads(): Single<List<Landpad>>

    @GET("landpads/{id}")
    fun getLandpad(@Path("id") id: Long): Single<Landpad>

    @GET("launches/past")
    fun getPastLaunches(): Single<List<UpcomingLaunch>>

    @GET("launches/upcoming")
    fun getUpcomingLaunches(): Single<List<UpcomingLaunch>>

    @GET("launches/latest")
    fun getLatestLaunch(): Single<UpcomingLaunch>

    @GET("launches/next")
    fun getNextLaunch(): Single<UpcomingLaunch>

    @GET("launches")
    fun getAllLaunches(): Single<List<UpcomingLaunch>>

    @Headers("Content-Type: application/json")
    @POST("launches/query")
    fun getLaunchesQuery(@Body queryBody: QueryBody): Single<Pagination<List<UpcomingLaunch>>>

    @GET("launches/{id}")
    fun getLaunch(@Path("id") id: Long): Single<Landpad>

    @GET("launchpads")
    fun getLaunchPads(): Single<List<Launchpad>>

    @GET("launchpads/{id}")
    fun getLaunchPad(@Path("id") id: Long): Single<Launchpad>

    @GET("payloads")
    fun getPayLoads(): Single<List<Payload>>

    @GET("payloads/{id}")
    fun getPayLoad(@Path("id") id: Long): Single<Payload>

    @GET("roadster")
    fun getRoadster(): Single<List<Roadster>>

    @GET("rockets")
    fun getRockets(): Single<List<Rocket>>

    @GET("rockets/{id}")
    fun getRocket(@Path("id") id: Long): Single<Rocket>

    @GET("ships")
    fun getShips(): Single<List<Ship>>

    @GET("ships/{id}")
    fun getShip(@Path("id") id: Long): Single<Ship>

    @GET("starlink")
    fun getStarlinks(): Single<List<Starlink>>

    @GET("starlink/{id}")
    fun getStarlink(@Path("id") id: Long): Single<Starlink>
}