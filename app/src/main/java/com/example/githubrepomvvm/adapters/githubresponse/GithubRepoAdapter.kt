package com.example.githubrepomvvm.adapters.githubresponse

import androidx.annotation.LayoutRes
import com.example.githubrepomvvm.R
import com.example.githubrepomvvm.databinding.RepoItemBinding
import com.example.githubrepomvvm.model.response.GithubResponse
import javax.inject.Inject
import javax.inject.Singleton


class GithubRepoAdapter(items: List<GithubResponse>) : BaseRecyclerViewAdapter<List<GithubResponse>, RepoItemBinding>(items) {
    @LayoutRes
    override fun getLayoutResId() = R.layout.repo_item

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.binding?.item = items[position]
    }

    fun updateItems(items1: List<GithubResponse>){
        items = items1
        notifyDataSetChanged()
    }


}