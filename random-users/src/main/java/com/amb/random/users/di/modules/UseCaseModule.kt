package com.amb.random.users.di.modules

import com.amb.random.users.domain.repository.RandomUserRepository
import com.amb.random.users.domain.usecase.RandomUserUseCase
import org.koin.dsl.module

internal class UseCaseModule {

    val useCaseModule = module {
        factory { RandomUserUseCase(get<RandomUserRepository>()) }
    }
}