package com.example.shikimorianilist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
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

        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.buttonGenerateAnime.setOnClickListener { generateRandomAnime() }

        binding.bBack.setOnClickListener { onBackPressed() }

        generateRandomAnime()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
            else -> return super.onOptionsItemSelected(item)
        }
        return true
    }

    fun generateRandomAnime() {
        binding.buttonGenerateAnime.isEnabled = false
        binding.pbRandomAnime.visibility = View.VISIBLE

        RetrofitClient
            .shikimoriAPI
            .getAnimeList(1, "random", 1, "")
            .enqueue(object : Callback<List<AnimeItem>?> {
                override fun onResponse(
                    call: Call<List<AnimeItem>?>,
                    response: Response<List<AnimeItem>?>
                ) {
                    val animeItem: AnimeItem = response.body()!![0]

                    binding.tvNameRU.text = animeItem.russian
                    binding.tvNameJP.text = animeItem.name
                    binding.tvScore.text = animeItem.score
                    binding.tvKind.text = animeItem.kind
                    binding.tvEpisodes.text = animeItem.episodes.toString()

                    Glide.with(this@MainActivity)
                        .load(RetrofitClient.getBaseURL() + animeItem.image.original)
                        .into(binding.ivAnimePoster)

                    binding.buttonGenerateAnime.isEnabled = true
                    binding.pbRandomAnime.visibility = View.GONE
                }

                override fun onFailure(call: Call<List<AnimeItem>?>, t: Throwable) {
                    binding.tvNameRU.text = t.toString()
                    binding.buttonGenerateAnime.isEnabled = true
                    binding.pbRandomAnime.visibility = View.GONE
                }
            })
    }
}