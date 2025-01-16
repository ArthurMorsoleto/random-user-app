package com.amb.random.users.di

import android.app.Application
import com.amb.random.users.di.modules.NetworkingModule
import com.amb.random.users.di.modules.RepositoryModule
import com.amb.random.users.di.modules.UseCaseModule
import com.amb.random.users.di.modules.ViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

internal object RandomUsersKoinContext {

    fun initialize(application: Application) {
        startKoin {
            androidContext(application)
            modules(
                NetworkingModule().networkModule,
                RepositoryModule().repositoryModule,
                UseCaseModule().useCaseModule,
                ViewModelModule().viewModelModule
            )
        }
    }
}