package com.example.meudesafiopicpay.data

class UsersRepository constructor(private val retrofitService: RetrofitService) {
    fun getAllUsers() = retrofitService.getAllUsers()
}