package com.amb.randomusersapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amb.randomusersapp.common.Response
import com.amb.randomusersapp.domain.usecase.RandomUserUseCase
import kotlinx.coroutines.launch

class RandomUserViewModel(
    private val useCase: RandomUserUseCase
) : ViewModel() {

    fun getRandomUser() = viewModelScope.launch {
        useCase().collect { result ->
            when (result) {
                is Response.Success -> {
                    // TODO show user info
                }

                is Response.Error -> {
                    // TODO show error
                }

                is Response.Loading -> {
                    // TODO show loading
                }
            }
        }
    }
}