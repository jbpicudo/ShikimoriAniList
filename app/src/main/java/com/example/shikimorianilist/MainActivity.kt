package com.example.shikimorianilist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.shikimorianilist.databinding.ActivityMainBinding
import com.example.shikimorianilist.modelAnimeList.AnimeItem
import com.example.shikimorianilist.networkRetrofitAPI.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonGenerateAnime.setOnClickListener { generateRandomAnime() }
    }

    fun generateRandomAnime() {
        RetrofitClient
            .shikimoriAPI
            .getAnimeList(1)
            .enqueue(object : Callback<List<AnimeItem>?> {
                override fun onResponse(
                    call: Call<List<AnimeItem>?>,
                    response: Response<List<AnimeItem>?>
                ) {
                    val animeItem: AnimeItem = response.body()!![0]

                    binding.tvNameRU.text = animeItem.russian
                    binding.tvNameJP.text = animeItem.name
                    binding.tvKind.text = animeItem.score
                    binding.tvKind.text = animeItem.kind
                    binding.tvEpisodes.text = animeItem.episodes.toString()

                    Glide.with(this@MainActivity)
                        .load(RetrofitClient.getBaseURL() + animeItem.image.original)
                        .into(binding.ivAnimePoster)
                }

                override fun onFailure(call: Call<List<AnimeItem>?>, t: Throwable) {
                    binding.tvNameRU.text = t.toString()
                }
            })
    }
}