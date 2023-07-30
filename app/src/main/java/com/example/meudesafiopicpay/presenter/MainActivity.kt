package com.example.meudesafiopicpay.presenter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.meudesafiopicpay.R
import com.example.meudesafiopicpay.UsersAdapter
import com.example.meudesafiopicpay.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var adapter = UsersAdapter()
    private val viewModel: UsersViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recycler.adapter = adapter
        binding.recycler2.adapter = adapter
        binding.recycler3.adapter = adapter
        binding.recycler4.adapter = adapter
        binding.recycler5.adapter = adapter
    }

    override fun onStart(){
        super.onStart()

        viewModel.userList.observe(this) { users ->
            adapter.setUserList(users.users)
        }

        viewModel.errorMessage.observe(this) {
            Toast.makeText(this, "falhou", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onResume() {
        super.onResume()

        viewModel.getAllUsers()
    }
}