package com.amb.random.users.domain.repository

import com.amb.random.users.data.remote.dto.RandomUserDto

internal interface RandomUserRepository {

    suspend fun getRandomUser(): RandomUserDto
}