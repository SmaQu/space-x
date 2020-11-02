package com.alastor.spacex.network

import com.alastor.spacex.model.Capsule
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CapsuleRepository @Inject constructor(private val capsuleService: CapsuleService) {

    fun getAllCapsules(): Single<List<Capsule>> {
        return capsuleService.getCapsules()
    }
}