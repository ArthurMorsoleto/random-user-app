package com.amb.random.users

import android.app.Application
import android.content.Context
import android.content.Intent
import com.amb.random.users.di.RandomUsersKoinContext
import com.amb.random.users.presentation.RandomUserActivity

object RandomUsersInitializer {

    fun init(application: Application) {
        RandomUsersKoinContext.initialize(application)
    }

    fun openRandomUserScreen(context: Context) {
        context.startActivity(Intent(context, RandomUserActivity::class.java))
    }
}