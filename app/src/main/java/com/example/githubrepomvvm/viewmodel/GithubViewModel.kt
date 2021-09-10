package com.example.githubrepomvvm.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.githubrepomvvm.model.response.BaseResponse
import com.example.githubrepomvvm.model.response.GithubOwnerResponse
import com.example.githubrepomvvm.model.response.GithubResponse
import com.example.githubrepomvvm.util.ApiHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class GithubViewModel(private val apiHelper: ApiHelper) :
    ViewModel() {

    private var _lists = MutableLiveData<BaseResponse<GithubResponse>>()
    val list = _lists

    private var _listUsers = MutableLiveData<List<GithubOwnerResponse>>()
    val listUsers = _listUsers

    fun getGithubViewModel(nickName: String) {
        apiHelper.getApiHelper(nickName).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

                Log.e("response", it.items.toString())
                _lists.postValue(it)
            }, {
                Log.e("response", "viewmodel failed to get resources")
            })
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