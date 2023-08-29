package com.example.myposts.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myposts.databinding.PostactivityBinding
import com.example.myposts.viewModel.PostViewModel

class PostAdapter(var postactivity:List<Posts>):RecyclerView.Adapter<PostAdapter.PostHolder>(){

    lateinit var binding: PostactivityBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        val binding =PostactivityBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PostHolder(binding)

    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        val currentPost =postactivity[position]
        val binding= holder.binding
        binding.tvid.text=currentPost.id.toString()
        binding.tvtitle.text=currentPost.title
        binding.tvbody.text=currentPost.body
    }

    override fun getItemCount(): Int {
        return postactivity.size

    }

    class PostHolder(var binding: PostactivityBinding):RecyclerView.ViewHolder(binding.root){

    }
}