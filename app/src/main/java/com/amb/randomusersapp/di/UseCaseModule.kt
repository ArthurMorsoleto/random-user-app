package com.amb.randomusersapp.di

import com.amb.randomusersapp.domain.repository.RandomUserRepository
import com.amb.randomusersapp.domain.usecase.RandomUserUseCase
import org.koin.dsl.module

class UseCaseModule {

    val useCaseModule = module {
        factory { RandomUserUseCase(get<RandomUserRepository>()) }
    }
}