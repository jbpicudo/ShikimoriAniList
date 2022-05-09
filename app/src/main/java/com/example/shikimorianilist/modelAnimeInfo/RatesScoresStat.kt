package com.example.shikimorianilist.modelAnimeInfo


import com.google.gson.annotations.SerializedName

data class RatesScoresStat(
    @SerializedName("name")
    val name: Int,
    @SerializedName("value")
    val value: Int
)