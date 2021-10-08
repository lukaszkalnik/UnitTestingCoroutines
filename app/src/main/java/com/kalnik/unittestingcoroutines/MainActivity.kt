package com.kalnik.unittestingcoroutines

import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModelProvider

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel = ViewModelProvider(
        this,
        MainViewModelFactory(ApiService.create("https://userservice.com"))
    ).get(MainViewModel::class.java)
}
