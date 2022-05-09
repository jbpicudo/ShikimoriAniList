package com.example.shikimorianilist.modelAnimeInfo


import com.google.gson.annotations.SerializedName

data class UserRate(
    @SerializedName("chapters")
    val chapters: Int,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("episodes")
    val episodes: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("rewatches")
    val rewatches: Int,
    @SerializedName("score")
    val score: Int,
    @SerializedName("status")
    val status: String,
    @SerializedName("text")
    val text: Any?,
    @SerializedName("text_html")
    val textHtml: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("volumes")
    val volumes: Int
)