package com.amb.random.users.data.remote.dto

import com.google.gson.annotations.SerializedName

internal data class EmploymentDto(
    @SerializedName("key_skill")
    val keySkill: String,
    @SerializedName("title")
    val title: String
)