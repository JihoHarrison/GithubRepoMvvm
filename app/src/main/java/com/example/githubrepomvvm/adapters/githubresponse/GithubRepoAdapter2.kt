package com.example.githubrepomvvm.adapters.githubresponse

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.githubrepomvvm.databinding.RepoItemBinding
import com.example.githubrepomvvm.databinding.UserRepoListBinding
import com.example.githubrepomvvm.model.response.GithubResponse
import com.example.githubrepomvvm.model.response.GithubSubResponse

class GithubRepoAdapter2(private val data : List<GithubResponse>): RecyclerView.Adapter<GithubRepoAdapter2.GithubUserViewHolder2>() {


    class GithubUserViewHolder2(val binding : RepoItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data : GithubResponse){
            binding.item = data
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GithubUserViewHolder2 {
        val binding = RepoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GithubUserViewHolder2(binding)
    }

    override fun onBindViewHolder(holder: GithubUserViewHolder2, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size
}