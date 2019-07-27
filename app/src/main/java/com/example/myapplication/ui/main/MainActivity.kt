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
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(),
                     MainContract.View {

    private lateinit var mainPresenter: MainPresenter

    private var mainAdapter: MainAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        mainPresenter = MainPresenter()
        mainPresenter.attachView(this)
        a_main_btn.setOnClickListener { mainPresenter.loadResults() }
    }

    private fun initViews() {
        mainAdapter = MainAdapter { startDetailActivity(it) }
        a_main_recycler.adapter = mainAdapter
        a_main_recycler.layoutManager = LinearLayoutManager(this)
        a_main_recycler.addItemDecoration(
                DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        mainPresenter.detachView()
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    override fun showResults(results: List<GithubRepoEntity>) {
        mainAdapter?.addAll(results)
    }

    override fun showProgress() {
        a_main_progress.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        a_main_progress.visibility = View.INVISIBLE
    }

    private fun startDetailActivity(it: GithubRepoEntity) {
        DetailsActivity.getIntent(this, it).startActivity(this)
    }
}
