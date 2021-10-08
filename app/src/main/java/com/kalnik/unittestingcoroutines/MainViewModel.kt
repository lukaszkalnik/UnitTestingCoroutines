package com.kalnik.unittestingcoroutines

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus
import kotlin.coroutines.CoroutineContext

class MainViewModel(
    private val apiService: ApiService,
    coroutineContext: CoroutineContext = Dispatchers.Default
) : ViewModel() {

    private val _user = MutableStateFlow<User?>(null)
    internal val user = _user.asStateFlow()

    private val scope = viewModelScope + coroutineContext

    init {
        scope.launch {
            val user = apiService.getUser()
            _user.value = user
        }
    }

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