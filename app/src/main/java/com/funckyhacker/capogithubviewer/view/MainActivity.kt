package com.funckyhacker.capogithubviewer.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.funckyhacker.capogithubviewer.R
import com.funckyhacker.capogithubviewer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val linearLayoutManager: LinearLayoutManager by lazy {
        LinearLayoutManager(this)
    }
    private val dividerItemDecoration: DividerItemDecoration by lazy {
        DividerItemDecoration(this, linearLayoutManager.orientation)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //Toolbar
        setSupportActionBar(binding.toolBar)
        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)
        actionbar.setHomeButtonEnabled(true)

        initList()
    }

    private fun initList() {
        binding.listView.layoutManager = linearLayoutManager
//        binding.listView.adapter = viewModel.linearAdapter
        binding.listView.addItemDecoration(dividerItemDecoration)
        binding.listView.adapter = null
    }
}
