package com.amb.randomusersapp.network

import com.amb.support.ApiBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import kotlin.reflect.KClass

class ApiBuilderImpl : ApiBuilder {

    private fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(20, TimeUnit.SECONDS)
            .connectTimeout(20, TimeUnit.SECONDS)
            .build()
    }

    private fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(RANDOM_USER_API_BASE_URL)
            .client(provideHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    override fun <T : Any> build(api: KClass<T>): T {
        return provideRetrofit().create(api.java)
    }

    companion object {
        private const val RANDOM_USER_API_BASE_URL = "https://random-data-api.com/api/"
    }
}