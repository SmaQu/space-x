package com.alastor.spacex.repository

import com.alastor.spacex.model.Capsule
import com.alastor.spacex.network.CapsuleService
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CapsuleRepository @Inject constructor(private val capsuleService: CapsuleService) {

    fun getAllCapsules(): Flowable<List<Capsule>> {
        return capsuleService.getCapsules()
    }
}