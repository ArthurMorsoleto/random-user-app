package com.amb.randomusersapp

import android.app.Application
import com.amb.card.RandomCreditCardInitializer
import com.amb.network.ApiBuilderImpl
import com.amb.random.users.RandomUsersInitializer
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initFeatures()
    }

    private fun initFeatures() {
        startKoin {
            androidContext(this@MyApplication)
            modules(RandomUsersInitializer.init(apiBuilder = ApiBuilderImpl()))
            modules(RandomCreditCardInitializer.init(apiBuilder = ApiBuilderImpl()))
        }
    }
}