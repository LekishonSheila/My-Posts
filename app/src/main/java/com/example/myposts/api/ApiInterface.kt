package com.example.myposts.api

import com.example.myposts.model.Posts
import com.example.myposts.model.PostsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("/posts")
    suspend fun getPosts(): Response<List<Posts>>

//    @GET("post/{id}")
//    suspend fun getPosts(@Path("id")  PostsId: Int): Response<Posts>
}