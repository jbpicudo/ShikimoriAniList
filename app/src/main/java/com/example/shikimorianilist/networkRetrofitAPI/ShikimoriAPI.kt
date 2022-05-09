package com.example.shikimorianilist.networkRetrofitAPI

import com.example.shikimorianilist.modelAnimeList.AnimeItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
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
    ): Call<List<AnimeItem>>


}