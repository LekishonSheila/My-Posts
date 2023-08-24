package com.example.myposts.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation

class UsersRvAdapter (var users:List<User>): RecyclerView.Adapter<UsersRvAdapter.UsersViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val binding =
            UsersListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UsersViewHolder(binding)

    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        val currentUser = users.get(position)
        val binding = holder.binding
        binding.tvid.text = currentUser.id.toString()
        binding.rvuserId.text = currentUser.firstName
        binding.rvtitle.text = currentUser.lastName
        binding.rvbody.text = currentUser.lastName

        Picasso
            .get().load(currentUser.image)
            .resize(80, 80)
            .centerInside()
            .transform(CropCircleTransformation())
            .into(binding.ivImage)
    }



    override fun getItemCount(): Int {
        return users.size

    }

    class UsersViewHolder(var binding: UsersListItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}