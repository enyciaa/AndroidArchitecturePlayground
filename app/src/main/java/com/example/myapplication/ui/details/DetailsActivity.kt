package com.example.myapplication.ui.details

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.services.GithubRepoEntity
import com.example.myapplication.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_details.*
import android.net.Uri
import android.view.View
import com.example.myapplication.R
import com.example.myapplication.extensions.startActivity
import com.example.myapplication.ui.base.LifecycleReceiver
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class DetailsActivity : BaseActivity() {

    companion object {
        const val REPOSITORY_KEY = "REPOSITORY_KEY"

        fun getIntent(originActivity: Activity, repository: GithubRepoEntity): Intent {
            val intent = Intent(originActivity, DetailsActivity::class.java)
            intent.putExtra(REPOSITORY_KEY, repository)
            return intent
        }
    }

    @Inject lateinit var detailsViewModel: DetailsViewModel

    override fun getLifecycleReceivers(): List<LifecycleReceiver> {
        return listOf(detailsViewModel)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val githubRepoEntity = intent.getParcelableExtra<GithubRepoEntity>(REPOSITORY_KEY)
        detailsViewModel.initData(githubRepoEntity)
        a_details_btn.setOnClickListener { detailsViewModel.onGoToRepositoryClicked() }
    }

    override fun onStart() {
        super.onStart()
        val disposable = detailsViewModel.viewStateEmitter.subscribe {
            if (it.urlAddressToGoTo.isNotBlank()) {
                Intent(Intent.ACTION_VIEW, Uri.parse(it.urlAddressToGoTo)).startActivity(this)
            }

            supportActionBar?.title = it.toolbarTitle
            a_details_txt.text = it.urlAddress
        }
        compositeDisposable.add(disposable)
    }
}
