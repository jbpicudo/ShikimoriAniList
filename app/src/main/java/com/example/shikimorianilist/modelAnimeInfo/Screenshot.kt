package com.example.shikimorianilist.modelAnimeInfo


import com.google.gson.annotations.SerializedName

data class Screenshot(
    @SerializedName("original")
    val original: String,
    @SerializedName("preview")
    val preview: String
)