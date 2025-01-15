package com.amb.randomusersapp.domain.usecase

import com.amb.randomusersapp.common.Response
import com.amb.randomusersapp.domain.model.User
import com.amb.randomusersapp.domain.repository.RandomUserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RandomUserUseCase(
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