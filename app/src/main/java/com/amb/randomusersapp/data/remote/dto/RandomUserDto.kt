package com.amb.randomusersapp.data.remote.dto

import com.amb.randomusersapp.domain.model.User
import com.amb.randomusersapp.domain.model.UserAddress
import com.amb.randomusersapp.domain.model.UserEmployment
import com.google.gson.annotations.SerializedName

data class RandomUserDto(
    @SerializedName("address")
    val address: AddressDto,
    @SerializedName("avatar")
    val avatar: String,
    @SerializedName("date_of_birth")
    val dateOfBirth: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("employment")
    val employment: EmploymentDto,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("last_name")
    val lastName: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("phone_number")
    val phoneNumber: String,
    @SerializedName("social_insurance_number")
    val socialInsuranceNumber: String,
    @SerializedName("uid")
    val uid: String,
    @SerializedName("username")
    val username: String
) {
    fun mapToUser(): User {
        return User(
            firstName = firstName,
            lastName = lastName,
            avatar = avatar,
            dateOfBirth = dateOfBirth,
            email = email,
            employment = UserEmployment(
                title = employment.title
            ),
            address = UserAddress(
                city = address.city,
                state = address.state,
                country = address.country
            )
        )
    }
}