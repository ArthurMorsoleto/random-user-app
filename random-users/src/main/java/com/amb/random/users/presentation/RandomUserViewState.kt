package com.amb.random.users.presentation

import com.amb.random.users.domain.model.User

internal data class RandomUserViewState(
    val isLoading: Boolean = true,
    val userData: User? = null,
    val error: String? = null
)
