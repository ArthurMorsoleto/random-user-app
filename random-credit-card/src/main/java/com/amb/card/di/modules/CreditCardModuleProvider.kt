package com.amb.card.di.modules

import com.amb.card.data.remote.CreditCardApi
import com.amb.card.data.repository.CreditCardRepositoryImpl
import com.amb.card.domain.repository.CreditCardRepository
import com.amb.card.domain.usecase.GetCreditCardUseCase
import com.amb.card.presentation.CreditCardViewModel
import com.amb.network.ApiBuilder
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal class CreditCardModuleProvider(apiBuilder: ApiBuilder) {

    private val creditCardRepositoryModule = module {
        factory<CreditCardRepository> { CreditCardRepositoryImpl(get<CreditCardApi>()) }
    }
    private val creditCardUseCaseModule = module {
        factory { GetCreditCardUseCase(get<CreditCardRepository>()) }
    }
    private val networkModule = module {
        factory<CreditCardApi> { apiBuilder.build(CreditCardApi::class) }
    }
    private val viewModelModule = module {
        viewModel { CreditCardViewModel(get<GetCreditCardUseCase>()) }
    }

    val creditCardModules = listOf(
        networkModule,
        creditCardUseCaseModule,
        creditCardRepositoryModule,
        viewModelModule
    )
}