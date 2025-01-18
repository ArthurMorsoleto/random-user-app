package com.amb.card.presentation

import com.amb.card.domain.model.CreditCard

internal data class CreditCardViewState(
    val isLoading: Boolean = true,
    val data: CreditCard? = null,
    val error: String? = null
)
