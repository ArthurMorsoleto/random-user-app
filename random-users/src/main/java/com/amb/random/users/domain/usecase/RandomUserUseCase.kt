package com.amb.random.users.domain.usecase

import com.amb.network.common.Response
import com.amb.random.users.domain.model.User
import com.amb.random.users.domain.repository.RandomUserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class RandomUserUseCase(
    private val repository: RandomUserRepository
) {
    suspend operator fun invoke(): Flow<Response<User>> = flow {
        try {
            emit(Response.Loading())
            val user = repository.getRandomUser().mapToUser()
            emit(Response.Success(data = user))
        } catch (e: Exception) {
            emit(Response.Error(e.localizedMessage ?: "error"))
        }
    }
}