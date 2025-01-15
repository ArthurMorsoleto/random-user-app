package com.amb.randomusersapp

import android.app.Application
import com.amb.randomusersapp.di.NetworkingModule
import com.amb.randomusersapp.di.RepositoryModule
import com.amb.randomusersapp.di.UseCaseModule
import com.amb.randomusersapp.di.ViewModelModule
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                NetworkingModule().networkModule,
                RepositoryModule().repositoryModule,
                UseCaseModule().useCaseModule,
                ViewModelModule().viewModelModule
            )
        }
    }
}