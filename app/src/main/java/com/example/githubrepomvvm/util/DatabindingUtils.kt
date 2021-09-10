package com.example.githubrepomvvm.util

import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.githubrepomvvm.adapters.githubUserAdapter.GithubUserAdapter
import com.example.githubrepomvvm.adapters.githubresponse.GithubRepoAdapter
import com.example.githubrepomvvm.model.response.GithubOwnerResponse
import com.example.githubrepomvvm.model.response.GithubResponse


object DatabindingUtils {

//    @BindingAdapter("bind_repoList")
//    @JvmStatic
//    fun bindRepoList(recyclerView: RecyclerView, items: ObservableArrayList<GithubOwnerResponse>) {
//        if (recyclerView.adapter == null) {
//            val lm = LinearLayoutManager(recyclerView.context)
//            val adapter = GithubUserAdapter(items)
//            recyclerView.layoutManager = lm
//            recyclerView.adapter = adapter
//        }
//        (recyclerView.adapter as GithubUserAdapter).items = items
//        recyclerView.adapter?.notifyDataSetChanged()
//    }

}