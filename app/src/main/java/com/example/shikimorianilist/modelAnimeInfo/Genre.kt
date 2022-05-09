package com.example.shikimorianilist.modelAnimeInfo


import com.google.gson.annotations.SerializedName

data class Genre(
    @SerializedName("id")
    val id: Int,
    @SerializedName("kind")
    val kind: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("russian")
    val russian: String
)