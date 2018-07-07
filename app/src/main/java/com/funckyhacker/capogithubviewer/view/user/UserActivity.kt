package com.funckyhacker.capogithubviewer.view.user

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.funckyhacker.capogithubviewer.R
import com.funckyhacker.capogithubviewer.databinding.ActivityUserBinding
import com.trello.rxlifecycle2.LifecycleTransformer
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import dagger.android.AndroidInjection
import javax.inject.Inject

class UserActivity : RxAppCompatActivity(), UserView {

    companion object {
        private const val ARG_LOGIN = "arg_login"

        fun createIntent(context: Context, login: String): Intent {
            return Intent(context, UserActivity::class.java).putExtra(ARG_LOGIN, login)
        }
    }

    @Inject lateinit var viewModel: UserViewModel

    private val binding: ActivityUserBinding by lazy {
        DataBindingUtil.setContentView<ActivityUserBinding>(this, R.layout.activity_user)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        //Toolbar
        setSupportActionBar(binding.toolBar)
        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)
        actionbar.setHomeButtonEnabled(true)
        val login = intent.getStringExtra(ARG_LOGIN) ?: ""
        viewModel.init(this, login)
        binding.viewModel = viewModel
    }

    override fun <T> getRxLifecycle(): LifecycleTransformer<T> {
        return bindToLifecycle()
    }
}
