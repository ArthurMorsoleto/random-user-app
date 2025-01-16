package com.amb.random.users.di.modules

import com.amb.random.users.data.remote.RandomApi
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

internal class NetworkingModule {

    val networkModule = module {
        single { provideHttpClient() }
        single { provideRetrofit(get<OkHttpClient>()) }
        single { provideService(get<Retrofit>()) }
    }

    private fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(20, TimeUnit.SECONDS)
            .connectTimeout(20, TimeUnit.SECONDS)
            .build()
    }

    private fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(RANDOM_USER_API_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun provideService(retrofit: Retrofit) = retrofit.create(RandomApi::class.java)

    companion object {
        const val RANDOM_USER_API_BASE_URL = "https://random-data-api.com/api/"
    }
}