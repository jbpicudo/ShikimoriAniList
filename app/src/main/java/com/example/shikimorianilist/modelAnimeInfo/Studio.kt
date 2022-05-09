package com.example.shikimorianilist.modelAnimeInfo


import com.google.gson.annotations.SerializedName

data class Studio(
    @SerializedName("filtered_name")
    val filteredName: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("real")
    val real: Boolean
)