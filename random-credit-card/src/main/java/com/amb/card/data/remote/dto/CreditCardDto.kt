package com.amb.card.data.remote.dto

import com.amb.card.domain.model.CreditCard
import com.google.gson.annotations.SerializedName

internal data class CreditCardDto(
    @SerializedName("credit_card_expiry_date")
    val creditCardExpiryDate: String,
    @SerializedName("credit_card_number")
    val creditCardNumber: String,
    @SerializedName("credit_card_type")
    val creditCardType: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("uid")
    val uid: String
) {
    fun mapToCreditCard(): CreditCard {
        return CreditCard(
            expiryDate = creditCardExpiryDate,
            number = creditCardNumber,
            type = creditCardType,
            id = id,
            uid = uid
        )
    }
}
