package com.example.myapplication.ui.details

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.navArgs
import com.example.myapplication.R
import com.example.myapplication.extensions.requireAppCompatActivity
import com.example.myapplication.extensions.startActivity
import com.example.myapplication.services.GithubRepoEntity
import com.example.myapplication.ui.base.BaseFragment
import com.example.myapplication.ui.base.LifecycleReceiver
import kotlinx.android.synthetic.main.fragment_details.*
import javax.inject.Inject

class DetailsFragment : BaseFragment() {

    @Inject lateinit var detailsViewModel: DetailsViewModel
    private val args: DetailsFragmentArgs by navArgs()

    override fun getLifecycleReceivers(): List<LifecycleReceiver> {
        return listOf(detailsViewModel)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailsViewModel.initData(args.repository)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(
            view: View,
            savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        a_details_btn.setOnClickListener { detailsViewModel.onGoToRepositoryClicked() }
    }

    override fun onStart() {
        super.onStart()
        val disposable = detailsViewModel.viewStateEmitter.subscribe {
            requireAppCompatActivity().supportActionBar?.title = it.toolbarTitle
            a_details_txt.text = it.urlAddress
        }
        compositeDisposable.add(disposable)
    }
}
