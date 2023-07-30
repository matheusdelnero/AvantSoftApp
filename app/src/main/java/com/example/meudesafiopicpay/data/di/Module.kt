package com.example.meudesafiopicpay.data.di

import com.example.meudesafiopicpay.data.RetrofitService
import com.example.meudesafiopicpay.data.UsersRepository
import com.example.meudesafiopicpay.presenter.UsersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private val retrofitService = RetrofitService.getInstance()

val mainModule = module {
    viewModel {
        UsersViewModel(UsersRepository(retrofitService))
    }
}