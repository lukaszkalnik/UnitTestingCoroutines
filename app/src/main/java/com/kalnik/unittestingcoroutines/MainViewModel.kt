package com.kalnik.unittestingcoroutines

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.plus
import kotlin.coroutines.CoroutineContext

class MainViewModel(
    private val apiService: ApiService,
    coroutineContext: CoroutineContext = Dispatchers.Default
) : ViewModel() {

    private val scope = viewModelScope + coroutineContext

}

class MainViewModelFactory(
    private val apiService: ApiService
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(apiService) as T
        }
        throw IllegalArgumentException("Wrong ViewModel class: ${modelClass.name}")
    }
}