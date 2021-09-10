package com.example.githubrepomvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.githubrepomvvm.util.ApiHelper

@Suppress("UNCHECKED_CAST")
class GithubViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GithubViewModel::class.java)){
            return GithubViewModel(apiHelper) as T
        }
        throw  IllegalArgumentException("Un repo")
    }

//    fun showRepos(vm: GithubViewModel, intentText: String, adapter: GithubRepoAdapter) {
//        vm.getGithubViewModel(intentText).subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({ items ->
//                adapter.updateItems(items.items)
//
////                itemGit = it.items
////                Log.e("response", it.items.toString())
////                binding.recyclerView.adapter = GithubRepoAdapter(itemGit)
//            }, {
//                Log.e("response", "viewmodel failed to get resources")
//            })
//    }
}

