package com.example.githubrepomvvm.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.githubrepomvvm.model.response.BaseResponse
import com.example.githubrepomvvm.model.response.GithubOwnerResponse
import com.example.githubrepomvvm.model.response.GithubResponse
import com.example.githubrepomvvm.repository.GithubRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class GithubViewModel @Inject constructor(private val githubRepository: GithubRepository) :
    ViewModel() {

    private var _lists = MutableLiveData<BaseResponse<GithubResponse>>()
    val list = _lists

    private var _listUsers = MutableLiveData<List<GithubOwnerResponse>>()
    val listUsers = _listUsers

    fun getGithubViewModel(nickName: String) {
        githubRepository.getApiHelper(nickName).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

                Log.e("response", it.items.toString())
                _lists.postValue(it)
            }, {
                Log.e("response", "viewmodel failed to get resources")
            }).addTo(compositeDisposable = CompositeDisposable())
    }


//    fun getGithubUserViewModel(nickName: String){
//        apiHelper.getUserApiHelper(nickName).subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//
//                Log.e("response", it.toString())
//                _listUsers.postValue(it)
//            }, {
//                Log.e("response", it.message.toString())
//                Log.e("response", "viewmodel failed to get resources")
//            })
//    }


//    fun getUserGithubViewModel(nickName: String) =
//        githubRepository.getUserGithubService(nickName)


}