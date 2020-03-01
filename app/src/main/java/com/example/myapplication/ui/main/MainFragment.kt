package com.example.myapplication.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.services.GithubRepoEntity
import com.example.myapplication.ui.base.BaseFragment
import com.example.myapplication.ui.base.LifecycleReceiver
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject

class MainFragment : BaseFragment() {

    companion object {
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }

    @Inject lateinit var mainViewModel: MainViewModel

    private var mainAdapter: MainAdapter? = null

    override fun getLifecycleReceivers(): List<LifecycleReceiver> {
        return listOf(mainViewModel)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(
            view: View,
            savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        mainAdapter = MainAdapter { mainViewModel.repoClicked(it) }
        a_main_recycler.adapter = mainAdapter
        a_main_recycler.layoutManager = LinearLayoutManager(requireActivity())
        a_main_recycler.addItemDecoration(
                DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        )
        a_main_btn.setOnClickListener { mainViewModel.loadResults() }
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
        }
        compositeDisposable.add(disposable)
    }
}
