package com.kalnik.unittestingcoroutines

import retrofit2.Retrofit
import retrofit2.http.GET

interface ApiService {

    @GET("user")
    suspend fun getUser(): User

    companion object {

        fun create(baseUrl: String): ApiService = Retrofit.Builder()
            .baseUrl(baseUrl)
            .build()
            .create(ApiService::class.java)
    }
}

data class User(val id: String, val name: String)
