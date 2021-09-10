package com.example.githubrepomvvm.adapters.githubUserAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.githubrepomvvm.databinding.UserRepoListBinding
import com.example.githubrepomvvm.model.response.GithubOwnerResponse
import com.example.githubrepomvvm.model.response.GithubResponse
import com.example.githubrepomvvm.model.response.GithubSubResponse

class GithubUserAdapter(private val data : List<GithubSubResponse>): RecyclerView.Adapter<GithubUserAdapter.GithubUserViewHolder>() {


    class GithubUserViewHolder(val binding : UserRepoListBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data : GithubSubResponse){
            binding.item = data
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GithubUserViewHolder {
        val binding = UserRepoListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GithubUserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GithubUserViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size
}