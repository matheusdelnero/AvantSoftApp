package com.example.meudesafiopicpay

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.meudesafiopicpay.data.UsersRepository
import com.example.meudesafiopicpay.domain.Users
import com.example.meudesafiopicpay.presenter.UsersViewModel
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class UsersViewModelTest3{

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val testDispatcher = TestCoroutineDispatcher()
    private val repository: UsersRepository = mockk()
    private val usersObserver: Observer<List<Users>> = mockk(relaxed = true)


    @Before fun setup() {
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun cleanUp(){
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }


    @Test
    fun `when onViewReady is called then it should call repository`(){

        instantiate().getAllUsers()

        coVerify { repository.getAllUsers() }
    }


    private fun instantiate(): UsersViewModel {
        val viewModel = UsersViewModel(repository)
        viewModel.userList.observeForever(usersObserver)
        return viewModel

    }

}