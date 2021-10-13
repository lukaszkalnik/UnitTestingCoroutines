package com.kalnik.unittestingcoroutines

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModelProvider

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel = ViewModelProvider(
        this,
        MainViewModelFactory(ApiService.create("https://userservice.com"))
    ).get(MainViewModel::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            UserInfo(viewModel)
        }
    }
}

@Composable
fun UserInfo(mainViewModel: MainViewModel) {
    val user = mainViewModel.user.collectAsState().value

    if (user != null) {
        Column {
            Text(text = "ID: ${user.id}")
            Text(text = "Name: ${user.name}")
        }
    } else {
        Text("No user data")
    }
}
