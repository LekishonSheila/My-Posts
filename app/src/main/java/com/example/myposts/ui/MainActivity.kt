package com.example.myposts.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myposts.databinding.ActivityMainBinding
import com.example.myposts.model.PostAdapter
import com.example.myposts.viewModel.PostViewModel

class MainActivity : AppCompatActivity() {
    val postViewModel:PostViewModel by viewModels()
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//
//        val recyclerView: RecyclerView = binding.rvRecycler
//        val gridLayoutManager = GridLayoutManager(this, 2)
//        recyclerView.layoutManager = gridLayoutManager
//      var postAdapter = PostAdapter(emptyList())
//        recyclerView.adapter = postAdapter


    }

    override fun onResume() {
        super.onResume()
        postViewModel.fetchPosts()
        postViewModel.postLiveData.observe(this, Observer{ postdisplay ->
            var postAdapter = PostAdapter(postdisplay ?: emptyList())
            binding.rvRecycler.layoutManager =LinearLayoutManager(this@MainActivity)
            binding.rvRecycler.adapter=postAdapter

            Toast.makeText(
                baseContext,
                "fetched ${postdisplay?.size} products",
                Toast.LENGTH_LONG
            ).show()

        })
        postViewModel.errorLiveData.observe(this, Observer{ error ->
            Toast.makeText(baseContext, error, Toast.LENGTH_LONG)
                .show()

        })
    }
}
