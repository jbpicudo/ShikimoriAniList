package com.example.shikimorianilist

import android.os.Bundle
import android.text.Html
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.shikimorianilist.databinding.ActivityAnimeInfoBinding
import com.example.shikimorianilist.modelAnimeInfo.AnimeInfo
import com.example.shikimorianilist.networkRetrofitAPI.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AnimeInfoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnimeInfoBinding

    var animeId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anime_info)

        binding = ActivityAnimeInfoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        animeId = intent.getIntExtra("animeId", 43608)

        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        loadAnimeInfo()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
            else -> return super.onOptionsItemSelected(item)
        }
        return true
    }

    fun loadAnimeInfo() {
        RetrofitClient
            .shikimoriAPI
            .getAnimeInfo(animeId)
            .enqueue(object : Callback<AnimeInfo?> {
                override fun onResponse(call: Call<AnimeInfo?>, response: Response<AnimeInfo?>) {
                    if (response.body() != null) {
                        var animeInfo: AnimeInfo = response.body()!!

                        binding.tvNameJP.text = animeInfo.name
                        binding.tvDescription.text = Html.fromHtml(animeInfo.descriptionHtml)

                        Glide.with(this@AnimeInfoActivity)
                            .load(RetrofitClient.getBaseURL() + animeInfo.image.original)
                            .into(binding.ivAnimeInfoCover)

                        binding.pbAnimeInfo.visibility = View.GONE
                    }
                }

                override fun onFailure(call: Call<AnimeInfo?>, t: Throwable) {
                    binding.tvNameRU.text = t.toString()
                }
            })
    }
}