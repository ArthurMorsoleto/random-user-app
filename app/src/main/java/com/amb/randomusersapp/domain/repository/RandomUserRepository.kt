package com.amb.randomusersapp.domain.repository

import com.amb.randomusersapp.data.remote.dto.RandomUserDto

interface RandomUserRepository {

    suspend fun getRandomUser(): RandomUserDto
}