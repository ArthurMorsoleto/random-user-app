package com.amb.card.presentation

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

    init {
        getCreditCard()
    }

    private fun getCreditCard() {
        viewModelScope.launch {
            useCase().onEach { response: Response<CreditCard> ->
                when (response) {
                    is Response.Error -> {
                        // TODO
                    }

                    is Response.Loading -> {
                        // TODO
                    }

                    is Response.Success -> {
                        // TODO
                    }
                }
            }.launchIn(this)
        }
    }
}