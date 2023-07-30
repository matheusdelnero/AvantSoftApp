package com.example.meudesafiopicpay.presenter

import androidx.lifecycle.*
import com.example.meudesafiopicpay.data.UsersRepository
import com.example.meudesafiopicpay.domain.Users
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UsersViewModel constructor(private val repository: UsersRepository) : ViewModel() {

    val userList = MutableLiveData<com.example.meudesafiopicpay.domain.Response>()
    val errorMessage = MutableLiveData<String>()







    fun getAllUsers(){

        viewModelScope.launch(Dispatchers.IO) {
            val request = repository.getAllUsers()

            request.enqueue(object : Callback<com.example.meudesafiopicpay.domain.Response>{




                override fun onResponse(
                    call: Call<com.example.meudesafiopicpay.domain.Response>,
                    response: Response<com.example.meudesafiopicpay.domain.Response>
                ) {
                    userList.postValue(response.body())
                }

                override fun onFailure(
                    call: Call<com.example.meudesafiopicpay.domain.Response>,
                    t: Throwable
                ) {
                    errorMessage.postValue(t.message)
                }
            })
        }
    }}