package com.example.myposts.viewModel

import androidx.lifecycle.MutableLiveData
import com.example.myposts.repository.PostsRepository

class PostsViewHolder {

    val postsRepo = PostsRepository()
    var productsLiveData = MutableLiveData<List<posts>>()
    var errorLiveData = MutableLiveData<String>()

    fun fetchPosts(){
        viewModelscope.launch {
            var response = postsRepo.getPosts()
            if(response.isSuccessful){
                productsLiveData.postValue(response.body()?.posts)
            }
            else{
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}