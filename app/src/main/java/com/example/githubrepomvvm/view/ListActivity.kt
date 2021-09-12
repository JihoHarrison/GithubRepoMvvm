package com.example.githubrepomvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.githubrepomvvm.R
import com.example.githubrepomvvm.adapters.githubresponse.GithubRepoAdapter2
import com.example.githubrepomvvm.databinding.ActivityListBinding
import com.example.githubrepomvvm.viewmodel.GithubViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding

    private val viewModel: GithubViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list)
//        viewModel = ViewModelProvider(
//            this
//        ).get(GithubViewModel::class.java)

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