package com.amb.card.data.repository

import com.amb.card.data.remote.CreditCardApi
import com.amb.card.data.remote.dto.CreditCardDto
import com.amb.card.domain.repository.CreditCardRepository

internal class CreditCardRepositoryImpl(
    private val api: CreditCardApi
) : CreditCardRepository {

    override suspend fun getCreditCard(): CreditCardDto {
        return api.getCreditCardInfo()
    }
}