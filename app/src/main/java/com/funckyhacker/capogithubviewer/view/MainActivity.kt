package com.funckyhacker.capogithubviewer.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.funckyhacker.capogithubviewer.R
import com.funckyhacker.capogithubviewer.databinding.ActivityMainBinding
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainView {

    @Inject
    lateinit var viewModel: MainViewModel

    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    private val linearLayoutManager: LinearLayoutManager by lazy {
        LinearLayoutManager(this)
    }
    private val dividerItemDecoration: DividerItemDecoration by lazy {
        DividerItemDecoration(this, linearLayoutManager.orientation)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        //Toolbar
        setSupportActionBar(binding.toolBar)
        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)
        actionbar.setHomeButtonEnabled(true)
        initList()
        viewModel.init(this)
    }

    override fun onResume() {
        super.onResume()
        viewModel.getAllList()
    }

    override fun setAdapter(adapter: MainAdapter) {
        binding.listView.adapter = adapter
    }

    private fun initList() {
        binding.listView.layoutManager = linearLayoutManager
        binding.listView.addItemDecoration(dividerItemDecoration)
    }
}
