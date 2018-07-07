package com.funckyhacker.capogithubviewer.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.funckyhacker.capogithubviewer.R
import com.funckyhacker.capogithubviewer.databinding.ActivityMainBinding
import com.funckyhacker.capogithubviewer.event.ClickItemEvent
import com.funckyhacker.capogithubviewer.view.user.UserActivity
import com.trello.rxlifecycle2.LifecycleTransformer
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import dagger.android.AndroidInjection
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import javax.inject.Inject

class MainActivity : RxAppCompatActivity(), MainView {

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

    override fun setAdapter(adapter: MainAdapter) {
        binding.listView.adapter = adapter
    }

    override fun <T> getRxLifecycle(): LifecycleTransformer<T> {
        return bindToLifecycle()
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    public override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    @Subscribe
    fun onClickItemEvent(event: ClickItemEvent) {
        startActivity(UserActivity.createIntent(this, event.user.login))
    }

    private fun initList() {
        binding.listView.layoutManager = linearLayoutManager
        binding.listView.addItemDecoration(dividerItemDecoration)
        binding.listView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val totalCount = recyclerView.adapter.itemCount//The number of item in adapter
                val childCount = recyclerView.childCount //The number of item which is shown on RecyclerView
                val firstPosition = linearLayoutManager.findFirstVisibleItemPosition() // The fist position of RecyclerView
                if (totalCount == childCount + firstPosition) {
                    // Paging
                    viewModel.getList(viewModel.getLastId())
                }
            }
        })
    }
}
