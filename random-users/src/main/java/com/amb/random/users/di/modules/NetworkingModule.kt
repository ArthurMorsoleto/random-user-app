package com.amb.random.users.di.modules

import com.amb.network.ApiBuilderImpl
import com.amb.random.users.data.remote.RandomApi
import org.koin.dsl.module

internal class NetworkingModule(apiBuilder: ApiBuilderImpl) {

    val networkModule = module {
        factory { apiBuilder.build(RandomApi::class) }
    }
}