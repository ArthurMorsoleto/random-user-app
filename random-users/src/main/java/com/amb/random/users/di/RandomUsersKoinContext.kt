package com.amb.random.users.di

import com.amb.network.ApiBuilderImpl
import com.amb.random.users.di.modules.NetworkingModule
import com.amb.random.users.di.modules.RepositoryModule
import com.amb.random.users.di.modules.UseCaseModule
import com.amb.random.users.di.modules.ViewModelModule
import org.koin.core.module.Module

internal object RandomUsersKoinContext {

    fun randomUsersModules(apiBuilder: ApiBuilderImpl): List<Module> {
        return listOf(
            NetworkingModule(apiBuilder).networkModule,
            RepositoryModule().repositoryModule,
            UseCaseModule().useCaseModule,
            ViewModelModule().viewModelModule
        )
    }
}