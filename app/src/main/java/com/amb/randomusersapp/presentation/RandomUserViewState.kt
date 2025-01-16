package com.amb.randomusersapp.presentation

import com.amb.randomusersapp.domain.model.User

data class RandomUserViewState(
    val isLoading: Boolean = true,
    val userData: User? = null,
    val error: String? = null
)
