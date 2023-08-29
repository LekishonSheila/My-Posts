package com.example.myposts.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myposts.model.Posts
import com.example.myposts.repository.PostsRepository
import kotlinx.coroutines.launch

class PostViewModel: ViewModel() {

    val postsRepo = PostsRepository()
    var postLiveData = MutableLiveData<List<Posts>>()
    var errorLiveData = MutableLiveData<String>()

    fun fetchPosts(){
        viewModelScope.launch {
            var response = postsRepo.getPosts()
            if(response.isSuccessful){
                val postslist=response.body()?:emptyList()
                postLiveData.postValue(postslist as
                    List<Posts>
                )
            }
            else{
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}