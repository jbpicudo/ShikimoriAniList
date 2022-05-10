package com.example.shikimorianilist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shikimorianilist.databinding.ActivityAnimeListBinding
import com.example.shikimorianilist.modelAnimeList.AnimeItem
import com.example.shikimorianilist.networkRetrofitAPI.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AnimeListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnimeListBinding
    private lateinit var animeListAdapter: AnimeListAdapter

    var page: Int = 1
    var isLoading: Boolean = false

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

        binding.rvAnimeList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)

                if (!recyclerView.canScrollVertically(1) && newState == RecyclerView.SCROLL_STATE_IDLE) {
                    if (!isLoading) {
                        page++
                        loadAnimeList()
                    }
                }
            }
        })

        loadAnimeList()
    }

    fun loadAnimeList() {
        isLoading = true

        RetrofitClient.shikimoriAPI.getAnimeList(20, "ranked", page, "")
            .enqueue(object : Callback<List<AnimeItem>?> {
                override fun onResponse(
                    call: Call<List<AnimeItem>?>,
                    response: Response<List<AnimeItem>?>
                ) {
                    var list: MutableList<AnimeItem> = arrayListOf()
                    list.addAll(response.body()!!)

                    animeListAdapter.addAnimeItem(list)

                    binding.tvPages.text = "Страница $page"
                    isLoading = false
                }

                override fun onFailure(call: Call<List<AnimeItem>?>, t: Throwable) {
                    binding.tvPages.text = t.toString()
                    isLoading = false
                }
            })
    }
}