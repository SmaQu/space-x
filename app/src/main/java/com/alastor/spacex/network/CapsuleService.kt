package com.alastor.spacex.network

import com.alastor.spacex.model.Capsule
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import javax.inject.Singleton

@Singleton
interface CapsuleService {

    @GET("capsules")
    fun getCapsules(): Single<List<Capsule>>

    @GET("capsules/{id}")
    fun getCapsule(@Path("id") id: Long): Single<Capsule>

}