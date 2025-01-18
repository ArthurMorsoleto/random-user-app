package com.amb.random.users.presentation

import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.amb.network.common.Response
import com.amb.random.users.domain.usecase.RandomUserUseCase
import com.amb.random.users.fakeUser
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class RandomUserViewModelTest {
    private lateinit var subject: RandomUserViewModel
    private val useCase = mockk<RandomUserUseCase>()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup() {
        Dispatchers.setMain(StandardTestDispatcher())
        mockUseCaseLoading()
        subject = RandomUserViewModel(useCase)
    }

    @Test
    fun testInitViewModelWithSuccess() = runTest {
        coEvery { useCase() } returns flow { emit(Response.Success(data = fakeUser.mapToUser())) }
        subject.getRandomUser()
        advanceUntilIdle()
        val response = subject.viewState.value
        assertTrue(response.userData?.email == fakeUser.email)
    }

    @Test
    fun testInitViewModelWithError() = runTest {
        coEvery { useCase() } returns flow { emit(Response.Error("error")) }
        subject.getRandomUser()
        advanceUntilIdle()
        val response = subject.viewState.value
        assertTrue(response.error == "error")
        assertTrue(response.userData == null)
    }

    private fun mockUseCaseLoading() {
        coEvery { useCase() } returns flow { emit(Response.Loading()) }
    }
}