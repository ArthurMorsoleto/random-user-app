package com.amb.randomusersapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class EmploymentDto(
    @SerializedName("key_skill")
    val keySkill: String,
    @SerializedName("title")
    val title: String
)