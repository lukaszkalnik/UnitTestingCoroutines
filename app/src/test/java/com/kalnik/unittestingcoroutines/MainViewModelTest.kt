package com.kalnik.unittestingcoroutines

import io.mockk.mockk
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension

class MainViewModelTest {

    private val apiService = mockk<ApiService>()

    @Test
    fun `when view model initialized then display user data`() {

    }
}
