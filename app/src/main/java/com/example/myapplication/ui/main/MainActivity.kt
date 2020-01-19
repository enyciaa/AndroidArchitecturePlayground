package com.example.myapplication.ui.main

import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.example.myapplication.R
import com.example.myapplication.services.GithubRepoEntity
import com.example.myapplication.ui.details.DetailsActivity
import com.example.myapplication.extensions.startActivity
import com.example.myapplication.ui.base.BaseActivity
import com.example.myapplication.ui.base.LifecycleReceiver
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject lateinit var mainViewModel: MainViewModel

    private var mainAdapter: MainAdapter? = null

    override fun getLifecycleReceivers(): List<LifecycleReceiver> {
        return listOf(mainViewModel)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        a_main_btn.setOnClickListener { mainViewModel.loadResults() }
    }

    private fun initViews() {
        mainAdapter = MainAdapter { startDetailActivity(it) }
        a_main_recycler.adapter = mainAdapter
        a_main_recycler.layoutManager = LinearLayoutManager(this)
        a_main_recycler.addItemDecoration(
                DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )
    }

    override fun onStart() {
        super.onStart()
        val disposable = mainViewModel.viewStateEmitter.subscribe {
            if (it.loadingIsVisible) {
                a_main_progress.visibility = View.VISIBLE
            } else {
                a_main_progress.visibility = View.INVISIBLE
            }
            mainAdapter?.addAll(it.results)
            if (it.error.isNotBlank()) {
                Toast.makeText(this, it.error, Toast.LENGTH_LONG).show()
            }
        }
        compositeDisposable.add(disposable)
    }

    private fun startDetailActivity(it: GithubRepoEntity) {
        DetailsActivity.getIntent(this, it).startActivity(this)
    }
}
