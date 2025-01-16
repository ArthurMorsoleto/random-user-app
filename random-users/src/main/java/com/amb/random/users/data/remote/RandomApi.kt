package com.amb.random.users.data.remote

import com.amb.random.users.data.remote.dto.RandomUserDto
import retrofit2.http.GET

internal interface RandomApi {

    @GET("/api/v2/users")
    suspend fun getRandomUser(): RandomUserDto
}