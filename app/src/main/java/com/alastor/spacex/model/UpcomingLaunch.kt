package com.alastor.spacex.model

import com.google.gson.annotations.SerializedName

data class UpcomingLaunch(
    @SerializedName("id") val id: String,
    @SerializedName("flight_number") val flightNumber: Int,
    @SerializedName("name") val name: String,
    @SerializedName("date_utc") val dateUTC: String,
    @SerializedName("date_unix") val dateUnix: Long,
    @SerializedName("date_local") val dateLocal: String,
    @SerializedName("date_precision") val datePrecision: DatePrecision,
    @SerializedName("static_fire_date_utc") val staticFireDateUTC: String?,
    @SerializedName("static_fire_date_unix") val staticFireDateUnix: Long,
    @SerializedName("tdb") val tdb: Boolean,
    @SerializedName("net") val net: Boolean,
    @SerializedName("window") val window: Int,
    @SerializedName("rocket") val rocket: String,
    @SerializedName("success") val success: Boolean,
    @SerializedName("failures") val failures: List<Failures>,
    @SerializedName("upcoming") val upcoming: Boolean,
    @SerializedName("details") val details: String,
    @SerializedName("fairings") val fairings: Fairings,
    @SerializedName("crew") val crew: List<String>,
    @SerializedName("ships") val ships: List<String>,
    @SerializedName("capsules") val capsules: List<String>,
    @SerializedName("payloads") val payloads: List<String>,
    @SerializedName("launchpad") val launchpad: String,
    @SerializedName("cores") val cores: List<Cores>,
    @SerializedName("links") val links: Links,
    @SerializedName("auto_update") val autoUpdate: Boolean
) {

    enum class DatePrecision(val value: String) {

        @SerializedName("half")
        HALF("half"),

        @SerializedName("quarter")
        QUARTER("quarter"),

        @SerializedName("year")
        YEAR("year"),

        @SerializedName("month")
        MONTH("month"),

        @SerializedName("day")
        DAY("day"),

        @SerializedName("hour")
        HOUR("hour")
    }

    data class Failures(
        @SerializedName("time") val time: Int,
        @SerializedName("altitude") val altitude: Int,
        @SerializedName("reason") val reason: String
    )

    data class Fairings(
        @SerializedName("reused") val reused: Boolean,
        @SerializedName("recovery_attempt") val recoveryAttempt: Boolean,
        @SerializedName("recovered") val recovered: Boolean,
        @SerializedName("ships") val ships: List<String>
    )

    data class Cores(
        @SerializedName("core") val core: String,
        @SerializedName("flight") val flight: Int,
        @SerializedName("gridfins") val gridfins: Boolean,
        @SerializedName("legs") val legs: Boolean,
        @SerializedName("reused") val reused: Boolean,
        @SerializedName("landing_attempt") val landingAttempt: Boolean,
        @SerializedName("landing_success") val landingSuccess: Boolean,
        @SerializedName("landing_type") val landingType: String,
        @SerializedName("landpad") val landpad: String
    )

    data class Links(
        @SerializedName("patch") val patch: Patch,
        @SerializedName("reddit") val reddit: Reddit,
        @SerializedName("flickr") val flickr: Flickr,
        @SerializedName("presskit") val presskit: String,
        @SerializedName("webcast") val webcast: String,
        @SerializedName("youtube_id") val youtubeId: String,
        @SerializedName("article") val article: String,
        @SerializedName("wikipedia") val wikipedia: String
    )

    data class Patch(
        @SerializedName("small") val small: String,
        @SerializedName("large") val large: String
    )

    data class Reddit(
        @SerializedName("campaign") val campaign: String,
        @SerializedName("launch") val launch: String,
        @SerializedName("media") val media: String,
        @SerializedName("recovery") val recovery: String
    )

    data class Flickr(
        @SerializedName("small") val small: List<String>,
        @SerializedName("original") val original: List<String>
    )
}
