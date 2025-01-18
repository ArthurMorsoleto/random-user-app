package com.amb.random.users

import android.content.Context
import android.content.Intent
import com.amb.network.ApiBuilder
import com.amb.random.users.di.RandomUsersModulesProvider
import com.amb.random.users.presentation.RandomUserActivity
import org.koin.core.module.Module

object RandomUsersInitializer {

    fun init(apiBuilder: ApiBuilder): List<Module> {
        return RandomUsersModulesProvider.randomUsersModules(apiBuilder)
    }

    fun openRandomUserScreen(context: Context) {
        context.startActivity(Intent(context, RandomUserActivity::class.java))
    }
}