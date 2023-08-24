package com.example.myposts.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myposts.R
import com.example.myposts.viewModel.usersViewModel

class MainActivity2 : AppCompatActivity() {

    val usersViewModel: usersViewModel by viewModel()
    lateinit var binding: MainActivity2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivity2().inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        usersViewModel.fetchUsers()
        usersViewModel.usersLiveData.observe(this, Observer { usersList ->
            Toast.makeText(
                baseContext,
                "fetched ${usersList?.size} users",
                Toast.LENGTH_LONG
            ).show()
            binding.rvUsers.layoutManager = LinearLayoutManager(this@MainActivity2)
            binding.rvUsers.adapter= UsersRvAdapter(usersList)

        })
        usersViewModel.errorlivedata.observe(this, Observer { error ->
            Toast.makeText(
                baseContext, error,
                Toast.LENGTH_LONG
            ).show()
        })

    }}