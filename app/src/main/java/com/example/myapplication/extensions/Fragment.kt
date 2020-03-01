package com.example.myapplication.extensions

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

fun Fragment.requireAppCompatActivity(): AppCompatActivity {
    return requireActivity() as? AppCompatActivity
           ?: throw IllegalStateException("Activity this fragment is attached to does not extend AppCompatActivity")
}
