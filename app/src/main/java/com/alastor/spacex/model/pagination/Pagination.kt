package com.alastor.spacex.model.pagination

import com.alastor.spacex.model.UpcomingLaunch
import com.google.gson.annotations.SerializedName

data class Pagination<T>(
    @SerializedName("docs") val docs: T,
    @SerializedName("totalDocs") val totalDocs: Int,
    @SerializedName("limit") val limit: Int,
    @SerializedName("totalPages") val totalPages: Int,
    @SerializedName("page") val page: Int,
    @SerializedName("pagingCounter") val pagingCounter: Int,
    @SerializedName("hasPrevPage") val hasPrevPage: Boolean,
    @SerializedName("hasNextPage") val hasNextPage: Boolean,
    @SerializedName("prevPage") val prevPage: Int,
    @SerializedName("nextPage") val nextPage: Int,
)