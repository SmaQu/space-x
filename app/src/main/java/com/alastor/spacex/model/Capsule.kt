package com.alastor.spacex.model

import com.google.gson.annotations.SerializedName
import javax.inject.Inject

data class Capsule(
    @SerializedName("id") val id: String,
    @SerializedName("reuse_count") val reuseCount: Int,
    @SerializedName("water_landings") val waterLandings: Int,
    @SerializedName("land_landings") val landLandings: Int,
    @SerializedName("last_update") val lastUpdate: String,
    @SerializedName("launches") val launches: List<String>,
    @SerializedName("serial") val serial: String,
    @SerializedName("status") val status: String,
    @SerializedName("type") val type: String
) {

}