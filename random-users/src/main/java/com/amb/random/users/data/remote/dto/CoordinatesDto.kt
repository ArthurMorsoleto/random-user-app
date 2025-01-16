package com.amb.random.users.data.remote.dto

import com.google.gson.annotations.SerializedName

internal data class CoordinatesDto(
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lng")
    val lng: Double
)