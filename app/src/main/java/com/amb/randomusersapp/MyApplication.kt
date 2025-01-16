package com.amb.randomusersapp

import android.app.Application
import com.amb.random.users.RandomUsersInitializer

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        RandomUsersInitializer.init(this@MyApplication)
    }
}