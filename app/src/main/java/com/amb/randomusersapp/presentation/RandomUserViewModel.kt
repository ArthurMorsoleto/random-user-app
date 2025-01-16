package com.amb.randomusersapp.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amb.randomusersapp.common.Response
import com.amb.randomusersapp.domain.usecase.RandomUserUseCase
import kotlinx.coroutines.launch

class RandomUserViewModel(
    private val useCase: RandomUserUseCase
) : ViewModel() {

    private val _viewState = mutableStateOf(RandomUserViewState())
    val viewState: State<RandomUserViewState> = _viewState

    init {
        getRandomUser()
    }

    fun getRandomUser() = viewModelScope.launch {
        useCase().collect { result ->
            _viewState.value = when (result) {
                is Response.Success -> {
                    RandomUserViewState(
                        isLoading = false,
                        userData = result.data
                    )
                }

                is Response.Error -> {
                    RandomUserViewState(
                        isLoading = false,
                        error = result.message
                    )
                }

                is Response.Loading -> RandomUserViewState(isLoading = true)
            }
        }
    }
}