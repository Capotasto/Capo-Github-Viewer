package com.funckyhacker.capogithubviewer.view

import com.funckyhacker.capogithubviewer.network.GithubRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class MainViewModelImpl @Inject constructor(private val repository: GithubRepository) : MainViewModel() {

    private lateinit var view: MainView
    private lateinit var adapter: MainAdapter

    override fun init(view: MainView) {
        this.view = view
        this.adapter = MainAdapter()
        view.setAdapter(adapter)
        getList(0)
    }

    override fun getList(id: Int) {
        repository.users(id)
                .compose(view.getRxLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {list -> adapter.setData(list)},
                        {e -> Timber.w(e)}
                )
    }

    override fun getLastId(): Int {
        val user = adapter.getLastItem() ?: return 0
        return user.id
    }
}
