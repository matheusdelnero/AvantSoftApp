package com.example.meudesafiopicpay
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.meudesafiopicpay.databinding.ContatosLayoutBinding
import com.example.meudesafiopicpay.domain.Users

class UsersAdapter : RecyclerView.Adapter<MainViewHolder>() {

    private var users = mutableListOf<Users>()

    fun setUserList(users: List<Users>) {

        this.users = users.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ContatosLayoutBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val user = users[position]
        holder.bind(user)
    }

    override fun getItemCount(): Int {
        return users.size
    }
}

class MainViewHolder(val binding: ContatosLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(user: Users) {

        binding.tvName.text = user.name
        binding.tvEmailText.text = user.email
        binding.tvAgeText.text = user.age
        binding.tvIdText.text = user.id


    }
}