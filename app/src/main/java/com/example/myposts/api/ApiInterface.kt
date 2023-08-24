package com.example.myposts.api

import com.example.myposts.model.Posts
import com.example.myposts.model.PostsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("/products")
    suspend fun getProducts(): Response<PostsResponse>

    @GET("products/{id}")
    suspend fun getProduct(@Path("id") productId: Int): Response<Posts>
}