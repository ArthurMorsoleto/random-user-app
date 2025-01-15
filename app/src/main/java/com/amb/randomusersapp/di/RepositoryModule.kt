package com.amb.randomusersapp.di

import com.amb.randomusersapp.data.remote.RandomApi
import com.amb.randomusersapp.data.repository.RandomUserRepositoryImpl
import com.amb.randomusersapp.domain.repository.RandomUserRepository
import org.koin.dsl.module

class RepositoryModule {

    val repositoryModule = module {
        factory<RandomUserRepository> { RandomUserRepositoryImpl(get<RandomApi>()) }
    }
}