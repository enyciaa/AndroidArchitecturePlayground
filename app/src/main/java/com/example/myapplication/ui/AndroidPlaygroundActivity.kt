package com.example.myapplication.ui

import android.os.Bundle
import com.example.myapplication.R
import dagger.android.support.DaggerAppCompatActivity

class AndroidPlaygroundActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android_playground)
    }
}