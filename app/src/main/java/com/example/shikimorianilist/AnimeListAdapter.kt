package com.example.shikimorianilist

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shikimorianilist.databinding.AnimeItemBinding
import com.example.shikimorianilist.databinding.ItemLoadingBinding
import com.example.shikimorianilist.modelAnimeList.AnimeItem
import com.example.shikimorianilist.networkRetrofitAPI.RetrofitClient

class AnimeListAdapter(private val animeItemList: MutableList<AnimeMarker>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val VIEW_TYPE_ANIME: Int = 1
    private val VIEW_TYPE_LOADING: Int = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == VIEW_TYPE_ANIME) {
            val binding = AnimeItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
            return ViewHolder(binding)
        } else {
            val binding = ItemLoadingBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
            return LoadingHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val animeMarker: AnimeMarker = animeItemList[position]

        if (animeMarker is AnimeItem) {
            val animeItem: AnimeItem = animeMarker

            (holder as ViewHolder).bind(animeItem)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when {
            animeItemList[position] is AnimeItem -> {
                VIEW_TYPE_ANIME
            }
            animeItemList[position] is LoadingItem -> {
                VIEW_TYPE_LOADING
            }
            else -> {
                throw IllegalStateException("Unknown View Type")
            }
        }
    }

    override fun getItemCount(): Int {
        return animeItemList.size
    }

    fun addAnimeItem(animeItemList: MutableList<AnimeMarker>) {
        this.animeItemList.addAll(animeItemList)
        notifyDataSetChanged()
    }

    fun removeLoading() {
        this.animeItemList.removeLast()
        notifyItemRemoved(animeItemList.size)
    }

    class ViewHolder(animeItemBinding: AnimeItemBinding) :
        RecyclerView.ViewHolder(animeItemBinding.root) {

        private val binding = animeItemBinding

        fun bind(animeItem: AnimeItem) {
            binding.tvTitle.text = animeItem.russian

            binding.constraintLayout.setOnClickListener(View.OnClickListener {
                val intent = Intent(itemView.context, AnimeInfoActivity::class.java).apply {
                    putExtra("animeId", animeItem.id)
                }
                itemView.context.startActivity(intent)
            })

            Glide.with(itemView.context)
                .load(RetrofitClient.getBaseURL() + animeItem.image.preview)
                .into(binding.ivAnimeCover)
        }
    }

    class LoadingHolder(itemLoadingBinding: ItemLoadingBinding) :
        RecyclerView.ViewHolder(itemLoadingBinding.root) {

        private val binding = itemLoadingBinding
    }
}