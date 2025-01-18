package com.amb.card.domain.model

internal data class CreditCard(
    val expiryDate: String,
    val number: String,
    val type: String,
    val id: Int,
    val uid: String
)