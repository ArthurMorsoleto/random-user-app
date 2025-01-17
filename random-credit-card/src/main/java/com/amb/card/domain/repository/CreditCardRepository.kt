package com.amb.card.domain.repository

import com.amb.card.data.remote.dto.CreditCardDto

internal interface CreditCardRepository {

    suspend fun getCreditCard(): CreditCardDto
}