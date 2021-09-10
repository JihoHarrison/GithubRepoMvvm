package com.example.githubrepomvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.githubrepomvvm.R
import com.example.githubrepomvvm.adapters.githubUserAdapter.GithubUserAdapter
import com.example.githubrepomvvm.adapters.githubresponse.GithubRepoAdapter
import com.example.githubrepomvvm.adapters.githubresponse.GithubRepoAdapter2
import com.example.githubrepomvvm.databinding.ActivityListBinding
import com.example.githubrepomvvm.model.response.GithubOwnerResponse
import com.example.githubrepomvvm.util.ApiHelper
import com.example.githubrepomvvm.util.RetrofitClient
import com.example.githubrepomvvm.viewmodel.GithubViewModel
import com.example.githubrepomvvm.viewmodel.GithubViewModelFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding
    private lateinit var viewModel: GithubViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list)
        viewModel = ViewModelProvider(
            this,
            GithubViewModelFactory(ApiHelper(RetrofitClient.getRetrofit))
        ).get(GithubViewModel::class.java)

        val intentText = intent.getStringExtra(MainActivity.REPONAME).toString()
        Log.e("response", intentText)

        viewModel.getGithubViewModel(intentText)

        viewModel.list.observe(this, Observer {
            binding.recyclerView.adapter = GithubRepoAdapter2(it.items)
        })

//        viewModel.getGithubUserViewModel(intentText)
//
//        viewModel.listUsers.observe(this, Observer {
//            Log.e("response", it.toString())
//        })




    }


}