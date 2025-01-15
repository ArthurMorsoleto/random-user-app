package com.amb.randomusersapp.di

import com.amb.randomusersapp.domain.usecase.RandomUserUseCase
import com.amb.randomusersapp.presentation.RandomUserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class ViewModelModule {

    val viewModelModule = module {
        viewModel { RandomUserViewModel(get<RandomUserUseCase>()) }
    }
}