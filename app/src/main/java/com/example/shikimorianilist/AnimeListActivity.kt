package com.example.shikimorianilist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shikimorianilist.databinding.ActivityAnimeListBinding
import com.example.shikimorianilist.modelAnimeList.AnimeItem
import com.example.shikimorianilist.networkRetrofitAPI.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AnimeListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnimeListBinding

    private lateinit var animeListAdapter: AnimeListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anime_list)

        binding = ActivityAnimeListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var list: MutableList<AnimeItem> = arrayListOf()
        animeListAdapter = AnimeListAdapter(list)

        binding.rvAnimeList.layoutManager = LinearLayoutManager(this)
        binding.rvAnimeList.adapter = animeListAdapter

        loadAnimeList()
    }

    fun loadAnimeList() {
        RetrofitClient.shikimoriAPI.getAnimeList(50, "ranked", 1, "")
            .enqueue(object : Callback<List<AnimeItem>?> {
                override fun onResponse(
                    call: Call<List<AnimeItem>?>,
                    response: Response<List<AnimeItem>?>
                ) {
                    var list: MutableList<AnimeItem> = arrayListOf()
                    list.addAll(response.body()!!)

                    animeListAdapter.addAnimeItem(list)
                }

                override fun onFailure(call: Call<List<AnimeItem>?>, t: Throwable) {
                    binding.tvPages.text = t.toString()
                }
            })
    }
}