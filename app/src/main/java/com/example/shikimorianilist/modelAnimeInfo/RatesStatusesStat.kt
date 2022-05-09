package com.example.shikimorianilist.modelAnimeInfo


import com.google.gson.annotations.SerializedName

data class RatesStatusesStat(
    @SerializedName("name")
    val name: String,
    @SerializedName("value")
    val value: Int
)