package com.amb.network

import kotlin.reflect.KClass

interface ApiBuilder {
    fun <T : Any> build(api: KClass<T>): T
}