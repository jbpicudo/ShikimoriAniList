package com.example.shikimorianilist.modelAnimeInfo


import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("original")
    val original: String,
    @SerializedName("preview")
    val preview: String,
    @SerializedName("x48")
    val x48: String,
    @SerializedName("x96")
    val x96: String
)