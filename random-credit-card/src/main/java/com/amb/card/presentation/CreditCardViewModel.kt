package com.amb.card.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amb.card.domain.model.CreditCard
import com.amb.card.domain.usecase.GetCreditCardUseCase
import com.amb.network.common.Response
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

internal class CreditCardViewModel(
    private val useCase: GetCreditCardUseCase
) : ViewModel() {

    private val _viewState = mutableStateOf(CreditCardViewState())
    val viewState: State<CreditCardViewState> = _viewState

    init {
        getCreditCard()
    }

    private fun getCreditCard() = viewModelScope.launch {
        useCase().onEach { response: Response<CreditCard> ->
            _viewState.value = when (response) {
                is Response.Error -> {
                    CreditCardViewState(
                        isLoading = false,
                        error = response.message
                    )
                }

                is Response.Loading -> {
                    CreditCardViewState(isLoading = true)
                }

                is Response.Success -> {
                    CreditCardViewState(
                        isLoading = false,
                        data = response.data
                    )
                }
            }
        }.launchIn(this)
    }
}