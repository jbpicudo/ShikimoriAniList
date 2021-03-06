package com.example.shikimorianilist.networkRetrofitAPI

import com.example.shikimorianilist.modelAnimeInfo.AnimeInfo
import com.example.shikimorianilist.modelAnimeList.AnimeItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ShikimoriAPI {

    @Headers(
        "Content-Type: application/json",
        "User-Agent: ShikimoriAniList",
        "Cache-Control: max-age=640000"
    )
    @GET("/api/animes")
    fun getAnimeList(
        @Query("limit") limit: Int,
        @Query("order") order: String,
        @Query("page") page: Int,
        @Query("search") search: String
    ): Call<List<AnimeItem>>

    @Headers(
        "Content-Type: application/json",
        "User-Agent: ShikiAniList",
        "Cache-Control: max-age=640000"
    )
    @GET("/api/animes/{id}")
    fun getAnimeInfo(@Path("id") id: Int): Call<AnimeInfo>

}