package com.amb.randomusersapp

import android.app.Application
import com.amb.random.users.RandomUsersInitializer
import com.amb.randomusersapp.network.ApiBuilderImpl

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        RandomUsersInitializer.init(
            application = this@MyApplication,
            apiBuilder = ApiBuilderImpl()
        )
    }
}