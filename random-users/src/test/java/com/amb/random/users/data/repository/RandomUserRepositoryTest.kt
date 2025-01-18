package com.amb.random.users.data.repository

import com.amb.random.users.data.remote.RandomApi
import com.amb.random.users.domain.repository.RandomUserRepository
import com.amb.random.users.fakeUser
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class RandomUserRepositoryTest {

    private lateinit var subject: RandomUserRepository
    private val api = mockk<RandomApi>()

    @Before
    fun setup() {
        subject = RandomUserRepositoryImpl(api)
    }

    @Test
    fun testGetRandomUserFromRepository() = runTest {
        coEvery { api.getRandomUser() } returns fakeUser
        val response = subject.getRandomUser()
        assertTrue(response == fakeUser)
    }
}