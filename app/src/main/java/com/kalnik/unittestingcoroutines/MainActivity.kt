package com.kalnik.unittestingcoroutines

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel = ViewModelProvider(
        this,
        MainViewModelFactory(ApiService.create("https://userservice.com"))
    ).get(MainViewModel::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            UserInfo(null)
        }

        lifecycleScope.launchWhenCreated {
            viewModel.user.collect {

            }
        }
    }
}

@Composable
fun UserInfo(user: User?) {
    if (user != null) {
        Column {
            Text(text = "ID: ${user.id}")
            Text(text = "Name: ${user.name}")
        }
    } else {
        Text("No user data")
    }
}

@Preview
@Composable
fun UserInfoWithData() {
    UserInfo(User("id123", "User Name"))
}

@Preview
@Composable
fun UserInfoNoData() {
    UserInfo(null)
}
