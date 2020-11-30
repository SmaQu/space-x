package com.alastor.spacex.repository

sealed class Resource<out T : Any> {
    data class Loading<out T : Any>(val data: T?) : Resource<T>()
    data class Success<out T : Any>(val data: T?) : Resource<T>()
    data class Error(val exception: Throwable) : Resource<Nothing>()
}