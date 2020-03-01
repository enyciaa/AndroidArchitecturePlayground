package com.example.myapplication.ui

import android.content.Intent
import android.net.Uri
import androidx.navigation.findNavController
import com.example.myapplication.R
import com.example.myapplication.di.SingleActivity
import com.example.myapplication.domain.Navigator
import com.example.myapplication.extensions.startActivity
import com.example.myapplication.services.GithubRepoEntity
import com.example.myapplication.ui.main.MainFragmentDirections
import javax.inject.Inject

@SingleActivity
class NavigatorImpl @Inject constructor(
        private val androidPlaygroundActivity: AndroidPlaygroundActivity
): Navigator {

    override fun goToDetails(githubRepoEntity: GithubRepoEntity) {
        val action = MainFragmentDirections.actionMainFragmentToDetailsFragment(githubRepoEntity)
        androidPlaygroundActivity.findNavController(R.id.nav_host_fragment).navigate(action)
    }

    override fun goToUrl(url: String) {
        Intent(Intent.ACTION_VIEW, Uri.parse(url)).startActivity(androidPlaygroundActivity)
    }
}