package com.example.myposts.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

//    val productsViewModel: PostsViewModel by viewModels()
    lateinit var binding: AppCompatActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivity.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
//     fetchPosts()
//        productsViewModel.fetchPosts()
//
//        productsViewModel.productsLiveData
//            .observe(this, Observer { productList ->
//                Toast
//                    .makeText(
//                        baseContext, "fetched ${productList?.size} products",
//                        Toast.LENGTH_SHORT
//                    )
//                    .show()
//                binding.tvPosts.layoutManager= LinearLayoutManager(this@MainActivity)
//                binding.rvPosts.adapter= ProductAdapter(productList)
//            })
//        productsViewModel.errorLiveData.observe(this, Observer{ error ->
//            Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
//        }
//        }}
