package com.amb.card.data.remote

import com.amb.card.data.remote.dto.CreditCardDto
import retrofit2.http.GET

internal interface CreditCardApi {

    @GET("/api/v2/credit_cards")
    suspend fun getCreditCardInfo(): CreditCardDto
}