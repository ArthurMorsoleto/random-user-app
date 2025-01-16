package com.amb.random.users.domain.model

internal data class User(
    val firstName: String,
    val lastName: String,
    val avatar: String,
    val dateOfBirth: String,
    val employment: UserEmployment,
    val address: UserAddress,
    val email: String
)