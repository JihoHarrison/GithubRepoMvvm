package com.example.githubrepomvvm.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.githubrepomvvm.R
import com.example.githubrepomvvm.databinding.ActivityMainBinding
import com.example.githubrepomvvm.viewmodel.GithubViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewmodel: GithubViewModel by viewModels()

    companion object {
        const val REPONAME = "repoName"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setViews()
    }

    private fun setViews() = with(binding) {
        btnSearch.setOnClickListener {
            startActivity(
                Intent(this@MainActivity, ListActivity::class.java).apply {
                    putExtra(REPONAME, editName.text.toString())
                }

            )
        }
    }
}











