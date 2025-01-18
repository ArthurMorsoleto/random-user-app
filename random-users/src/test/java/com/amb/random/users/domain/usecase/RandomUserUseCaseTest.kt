package com.amb.random.users.domain.usecase

import com.amb.network.common.Response
import com.amb.random.users.domain.repository.RandomUserRepository
import com.amb.random.users.fakeUser
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import okio.IOException
import org.junit.After
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class RandomUserUseCaseTest {

    private lateinit var subject: RandomUserUseCase
    private val repository = mockk<RandomUserRepository>()

    @Before
    fun setup() {
        Dispatchers.setMain(StandardTestDispatcher())
        subject = RandomUserUseCase(repository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun testGetRandomUseCaseLoading() = runTest {
        coEvery { repository.getRandomUser() } returns fakeUser
        val response = subject.invoke().toList()
        assertTrue(response.first() is Response.Loading)
    }

    @Test
    fun testGetRandomUseCaseSuccessFlow() = runTest {
        coEvery { repository.getRandomUser() } returns fakeUser
        val response = subject.invoke().toList()
        assertTrue(response.last() is Response.Success)
    }

    @Test
    fun testGetRandomUseCaseErrorFlow() = runTest {
        coEvery { repository.getRandomUser() } throws IOException("network fake error")
        val response = subject.invoke().toList().last() as Response.Error
        assertTrue(response.message == "network fake error")
    }
}