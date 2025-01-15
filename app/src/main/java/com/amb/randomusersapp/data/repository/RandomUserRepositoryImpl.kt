package com.amb.randomusersapp.data.repository

import com.amb.randomusersapp.data.remote.RandomApi
import com.amb.randomusersapp.data.remote.dto.RandomUserDto
import com.amb.randomusersapp.domain.repository.RandomUserRepository

class RandomUserRepositoryImpl(
    private val api: RandomApi
) : RandomUserRepository {

    override suspend fun getRandomUser(): RandomUserDto {
        return api.getRandomUser()
    }
}
