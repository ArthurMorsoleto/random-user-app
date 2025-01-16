package com.amb.random.users.di.modules

import com.amb.random.users.data.remote.RandomApi
import com.amb.random.users.data.repository.RandomUserRepositoryImpl
import com.amb.random.users.domain.repository.RandomUserRepository
import org.koin.dsl.module

internal class RepositoryModule {

    val repositoryModule = module {
        factory<RandomUserRepository> { RandomUserRepositoryImpl(get<RandomApi>()) }
    }
}