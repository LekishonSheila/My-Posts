package com.example.myposts.repository

import com.example.myposts.api.ApiClient
import com.example.myposts.api.ApiInterface
import com.example.myposts.model.Posts
import com.example.myposts.model.PostsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class PostsRepository {

    val apiClient = ApiClient.buildClient(ApiInterface::class.java)
    suspend fun getPosts():Response<List<Posts>>{
        return withContext(Dispatchers.IO){
             apiClient.getPosts()
        }

    }
}