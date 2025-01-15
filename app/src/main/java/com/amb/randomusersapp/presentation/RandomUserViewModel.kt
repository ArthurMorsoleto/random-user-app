package com.amb.randomusersapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amb.randomusersapp.domain.usecase.RandomUserUseCase
import kotlinx.coroutines.launch

class RandomUserViewModel(
    private val useCase: RandomUserUseCase
) : ViewModel() {

    fun getRandomUser() = viewModelScope.launch {
        useCase().collect { result ->
            println(result)
        }
    }
}