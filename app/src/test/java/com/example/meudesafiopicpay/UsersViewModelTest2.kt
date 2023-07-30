package com.example.meudesafiopicpay

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.meudesafiopicpay.data.UsersRepository
import com.example.meudesafiopicpay.domain.Users
import com.example.meudesafiopicpay.presenter.UsersViewModel
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class UsersViewModelTest2 {
    @get:Rule
    val rule  =  InstantTaskExecutorRule()
    private val repository: UsersRepository = mockk()
    private val userObserver: Observer<List<Users>> = mockk(relaxed = true)


    @Test
    fun `when view model fetches data then it should call the repository`() {
        val viewModel = instantiate()
        viewModel.getAllUsers()
        verify { repository.getAllUsers() }
    }



    private fun instantiate(): UsersViewModel {
        val viewModel = UsersViewModel(repository)
        viewModel.userList.observeForever(userObserver)
        return viewModel
    }




}