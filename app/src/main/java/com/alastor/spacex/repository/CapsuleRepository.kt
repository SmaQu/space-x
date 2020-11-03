package com.alastor.spacex.repository

import com.alastor.spacex.model.Capsule
import com.alastor.spacex.network.CapsuleService
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CapsuleRepository @Inject constructor(private val capsuleService: CapsuleService) {

    fun getAllCapsules(): Single<List<Capsule>> {
        return capsuleService.getCapsules()
    }
}