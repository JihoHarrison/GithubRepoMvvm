package com.example.githubrepomvvm.view

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.githubrepomvvm.R
import com.example.githubrepomvvm.adapters.githubresponse.GithubRepoAdapter2
import com.example.githubrepomvvm.databinding.ActivityListBinding
import com.example.githubrepomvvm.viewmodel.GithubViewModel
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers


@AndroidEntryPoint
class ListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding

    private val viewModel: GithubViewModel by viewModels()
    private lateinit var adapter: GithubRepoAdapter2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list)

        val intentText = intent.getStringExtra(MainActivity.REPONAME).toString()

        viewModel.getGithubViewModelRx(intentText)

        viewModel.listProcessor
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    adapter = GithubRepoAdapter2(it)
                    with(binding) {
                        recyclerView.adapter = adapter
                    }
                    Log.d("processorhello", it.toString())
                }, {

                }
            ).addTo(CompositeDisposable())
    }
}