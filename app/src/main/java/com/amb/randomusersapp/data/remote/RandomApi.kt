package com.amb.randomusersapp.data.remote

import com.amb.randomusersapp.data.remote.dto.RandomUserDto
import retrofit2.http.GET

interface RandomApi {

    @GET("/users")
    suspend fun getRandomUser(): RandomUserDto
}