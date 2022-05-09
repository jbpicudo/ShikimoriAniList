package com.example.shikimorianilist.modelAnimeInfo


import com.google.gson.annotations.SerializedName

data class AnimeInfo(
    @SerializedName("aired_on")
    val airedOn: String,
    @SerializedName("anons")
    val anons: Boolean,
    @SerializedName("description")
    val description: String,
    @SerializedName("description_html")
    val descriptionHtml: String,
    @SerializedName("description_source")
    val descriptionSource: Any,
    @SerializedName("duration")
    val duration: Int,
    @SerializedName("english")
    val english: List<String>,
    @SerializedName("episodes")
    val episodes: Int,
    @SerializedName("episodes_aired")
    val episodesAired: Int,
    @SerializedName("fandubbers")
    val fandubbers: List<String>,
    @SerializedName("fansubbers")
    val fansubbers: List<String>,
    @SerializedName("favoured")
    val favoured: Boolean,
    @SerializedName("franchise")
    val franchise: String,
    @SerializedName("genres")
    val genres: List<Genre>,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: Image,
    @SerializedName("japanese")
    val japanese: List<String>,
    @SerializedName("kind")
    val kind: String,
    @SerializedName("license_name_ru")
    val licenseNameRu: String,
    @SerializedName("licensors")
    val licensors: List<String>,
    @SerializedName("myanimelist_id")
    val myanimelistId: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("next_episode_at")
    val nextEpisodeAt: Any,
    @SerializedName("ongoing")
    val ongoing: Boolean,
    @SerializedName("rates_scores_stats")
    val ratesScoresStats: List<RatesScoresStat>,
    @SerializedName("rates_statuses_stats")
    val ratesStatusesStats: List<RatesStatusesStat>,
    @SerializedName("rating")
    val rating: String,
    @SerializedName("released_on")
    val releasedOn: String,
    @SerializedName("russian")
    val russian: String,
    @SerializedName("score")
    val score: String,
    @SerializedName("screenshots")
    val screenshots: List<Screenshot>,
    @SerializedName("status")
    val status: String,
    @SerializedName("studios")
    val studios: List<Studio>,
    @SerializedName("synonyms")
    val synonyms: List<String>,
    @SerializedName("thread_id")
    val threadId: Int,
    @SerializedName("topic_id")
    val topicId: Int,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("user_rate")
    val userRate: UserRate,
    @SerializedName("videos")
    val videos: List<Video>
)