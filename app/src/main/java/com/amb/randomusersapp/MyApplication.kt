package com.amb.randomusersapp

import android.app.Application
import com.amb.network.ApiBuilderImpl
import com.amb.random.users.RandomUsersInitializer

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        RandomUsersInitializer.init(
            application = this@MyApplication,
            apiBuilder = ApiBuilderImpl()
        )
    }
}