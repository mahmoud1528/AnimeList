package com.example.animelistapi.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.animelistapi.data.model.resp.Media
import com.example.animelistapi.data.repository.iListRepository

class AnimeDetailViewModel(private val animeDetailRepository: iListRepository) : ViewModel() {

    var animeDetail = listOf<Media>()
    suspend fun getAnimeDetail() {
        val response = animeDetailRepository.getAnimeDetails()
        if (response.isSuccessful) {
            animeDetail = response.body()?.data?.Page?.media ?: emptyList()
            Log.d("AnimeDetailViewModel", "${response.body()}")
        }
    }
}