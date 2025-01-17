package com.amb.card.domain.usecase

import com.amb.card.domain.model.CreditCard
import com.amb.card.domain.repository.CreditCardRepository
import com.amb.network.common.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class GetCreditCardUseCase(
    private val repository: CreditCardRepository
) {
    suspend operator fun invoke(): Flow<Response<CreditCard>> = flow {
        try {
            emit(Response.Loading())
            val creditCard = repository.getCreditCard().mapToCreditCard()
            emit(Response.Success(data = creditCard))
        } catch (e: Exception) {
            emit(Response.Error(e.localizedMessage ?: "error"))
        }
    }
}