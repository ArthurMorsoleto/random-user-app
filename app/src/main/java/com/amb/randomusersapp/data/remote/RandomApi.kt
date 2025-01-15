package com.amb.randomusersapp.data.remote

import com.amb.randomusersapp.data.remote.dto.RandomUserDto
import retrofit2.http.GET

interface RandomApi {

    @GET("/api/v2/users")
    suspend fun getRandomUser(): RandomUserDto
}