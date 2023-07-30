package com.example.meudesafiopicpay

import com.example.meudesafiopicpay.data.RetrofitService
import com.example.meudesafiopicpay.data.UsersRepository
import com.example.meudesafiopicpay.presenter.UsersViewModel
import org.junit.Assert.*
import org.junit.Test


class UsersViewModelTest {

    private val repository = UsersRepository(RetrofitService.getInstance())

    @Test
    fun `liveData receives data`(){

        val result = UsersViewModel(repository).liveDataReceivesData()

        assertFalse(result)


    }


}