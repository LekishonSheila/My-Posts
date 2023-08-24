package com.example.myposts.model

data class PostsResponse(
    var posts: List<Posts>,
    var total: Int,
    var skip: Int,
    var limit: Int
)
