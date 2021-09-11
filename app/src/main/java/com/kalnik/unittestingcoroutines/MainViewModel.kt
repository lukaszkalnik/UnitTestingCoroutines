package com.kalnik.unittestingcoroutines

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.plus
import kotlin.coroutines.CoroutineContext

class MainViewModel(
    coroutineContext: CoroutineContext = Dispatchers.Default
) : ViewModel() {

    private val scope = viewModelScope + coroutineContext



}