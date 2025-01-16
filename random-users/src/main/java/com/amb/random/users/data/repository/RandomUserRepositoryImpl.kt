package com.amb.random.users.data.repository

import com.amb.random.users.data.remote.RandomApi
import com.amb.random.users.data.remote.dto.RandomUserDto
import com.amb.random.users.domain.repository.RandomUserRepository

internal class RandomUserRepositoryImpl(
    private val api: RandomApi
) : RandomUserRepository {

    override suspend fun getRandomUser(): RandomUserDto {
        return api.getRandomUser()
    }
}
