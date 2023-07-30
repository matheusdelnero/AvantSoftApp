package com.example.meudesafiopicpay.data

import com.example.meudesafiopicpay.domain.Response
import com.example.meudesafiopicpay.domain.Users
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {

    @GET("ce47ee53-6531-4821-a6f6-71a188eaaee0")
    fun getAllUsers(): Call<Response>

    companion object {
        private val retrofitService: RetrofitService by lazy{

            val retrofit = Retrofit.Builder()
                .baseUrl("https://run.mocky.io/v3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            retrofit.create(RetrofitService::class.java)
        }

        fun getInstance() : RetrofitService {
            return retrofitService
        }
    }
}