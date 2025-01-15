package com.amb.randomusersapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class AddressDto(
    @SerializedName("city")
    val city: String,
    @SerializedName("coordinates")
    val coordinates: CoordinatesDto,
    @SerializedName("country")
    val country: String,
    @SerializedName("state")
    val state: String,
    @SerializedName("street_address")
    val streetAddress: String,
    @SerializedName("street_name")
    val streetName: String,
    @SerializedName("zip_code")
    val zipCode: String
)