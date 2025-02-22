package com.example.animelistapi.ui.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.animelistapi.data.model.resp.Media
import com.example.animelistapi.databinding.ListframeBinding

class AnimeListAdapter(private val animeList: LiveData<List<Media>>,
                       private val onAnimeClick:(Int) -> Unit):
    RecyclerView.Adapter<AnimeListAdapter.AnimeListViewHolder>() {

    class AnimeListViewHolder(val binding: ListframeBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeListViewHolder {
        val binding = ListframeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return AnimeListViewHolder(binding)
    }

    override fun getItemCount(): Int = animeList.value?.size!!

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: AnimeListViewHolder, position: Int) {
        val anime = animeList.value?.get(position)
        holder.binding.apply {

            tvAnimeTitle.text = anime?.title?.romaji
            tvAnimeEpisode.text = anime?.episodes.toString() + " Episodes"
            tvAnimeRate.text = anime?.averageScore?.toFloat()?.div(10).toString()

            Glide.with(ivAnimeImage.context)
                .load(anime?.coverImage?.large)
                .into(ivAnimeImage)

            root.setOnClickListener {
                onAnimeClick(anime?.id!!) // Pass anime ID
            }
        }
    }
}