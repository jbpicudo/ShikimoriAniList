package com.example.shikimorianilist.modelAnimeInfo


import com.google.gson.annotations.SerializedName

data class Video(
    @SerializedName("hosting")
    val hosting: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("kind")
    val kind: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("player_url")
    val playerUrl: String,
    @SerializedName("url")
    val url: String
)