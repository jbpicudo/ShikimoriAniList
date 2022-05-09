package com.example.shikimorianilist.networkRetrofitAPI

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URL: String = "https://shikimori.one"

    private val retrofit : Retrofit by lazy {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    val shikimoriAPI: ShikimoriAPI by lazy {
        retrofit.create(ShikimoriAPI::class.java)
    }

    fun getBaseURL(): String {
        return BASE_URL
    }
}