package com.amb.randomusersapp.network

import kotlin.reflect.KClass

interface ApiBuilder {
    fun <T : Any> build(api: KClass<T>): T
}