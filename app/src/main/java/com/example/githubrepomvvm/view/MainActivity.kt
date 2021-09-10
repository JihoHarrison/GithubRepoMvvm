package com.example.githubrepomvvm.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.MainThread
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.githubrepomvvm.R
import com.example.githubrepomvvm.databinding.ActivityMainBinding
import com.example.githubrepomvvm.util.DatabindingUtils
import com.example.githubrepomvvm.util.RetrofitClient
import com.example.githubrepomvvm.viewmodel.GithubViewModel
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    companion object{
        const val REPONAME = "repoName"
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setViews()



    }

    private fun setViews() = with(binding){
        btnSearch.setOnClickListener {
            startActivity(
                Intent(this@MainActivity, ListActivity::class.java).apply {
                    putExtra(REPONAME, editName.text.toString())
                }

            )
        }
    }


}











