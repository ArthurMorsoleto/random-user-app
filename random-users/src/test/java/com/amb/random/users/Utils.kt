package com.amb.random.users

import com.amb.random.users.data.remote.dto.AddressDto
import com.amb.random.users.data.remote.dto.CoordinatesDto
import com.amb.random.users.data.remote.dto.EmploymentDto
import com.amb.random.users.data.remote.dto.RandomUserDto

internal val fakeUser = RandomUserDto(
    address = AddressDto(
        city = "city",
        coordinates = CoordinatesDto(lat = 1.0, lng = 1.0),
        country = "country",
        state = "state",
        streetAddress = "streetAddress",
        streetName = "streetName",
        zipCode = "zipCode"
    ),
    avatar = "avatar",
    dateOfBirth = "date",
    email = "email@email.com",
    employment = EmploymentDto("skill", "title"),
    firstName = "first name",
    gender = "gender",
    id = 2,
    lastName = "last name",
    password = "password",
    phoneNumber = "phoneNumber",
    socialInsuranceNumber = "socialInsuranceNumber",
    uid = "last name",
    username = "username",
)