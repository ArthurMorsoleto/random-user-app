package com.amb.random.users.di.modules

import com.amb.random.users.domain.usecase.RandomUserUseCase
import com.amb.random.users.presentation.RandomUserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal class ViewModelModule {

    val viewModelModule = module {
        viewModel { RandomUserViewModel(get<RandomUserUseCase>()) }
    }
}