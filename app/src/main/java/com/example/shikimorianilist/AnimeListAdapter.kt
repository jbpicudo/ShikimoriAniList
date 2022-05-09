package com.example.shikimorianilist

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shikimorianilist.databinding.AnimeItemBinding
import com.example.shikimorianilist.modelAnimeList.AnimeItem
import com.example.shikimorianilist.networkRetrofitAPI.RetrofitClient

class AnimeListAdapter(private val animeItemList: MutableList<AnimeItem>) :
    RecyclerView.Adapter<AnimeListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = AnimeItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val animeItem = animeItemList[position]
        holder.bind(animeItem)
    }

    override fun getItemCount(): Int {
        return animeItemList.size
    }

    fun addAnimeItem(animeItemList: MutableList<AnimeItem>) {
        this.animeItemList.addAll(animeItemList)
        notifyDataSetChanged()
    }

    class ViewHolder(animeItemLayoutBinding: AnimeItemBinding) :
        RecyclerView.ViewHolder(animeItemLayoutBinding.root) {

        private val binding = animeItemLayoutBinding

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
}