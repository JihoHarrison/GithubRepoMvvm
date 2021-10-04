package com.example.githubrepomvvm.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.githubrepomvvm.model.response.GithubResponse
import com.example.githubrepomvvm.repository.GithubRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.processors.BehaviorProcessor
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class GithubViewModel @Inject constructor(private val githubRepository: GithubRepository) :
    ViewModel() {

    private val _listProcessor: BehaviorProcessor<List<GithubResponse>> =
        BehaviorProcessor.createDefault(emptyList())
    val listProcessor: Flowable<List<GithubResponse>> = _listProcessor

    fun getGithubViewModelRx(nickName: String) {
        githubRepository.getApiHelperWithRx(nickName).subscribeOn(Schedulers.io())
            .map { listOf(it).flatten().sortedBy { it.updatedAt }.reversed() }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _listProcessor.offer(it)
            }, {
                Log.e("GithubViewModel", "failed to getGithubViewModelRx ${it.message}")
            })
            .addTo(compositeDisposable = CompositeDisposable())
    }
}