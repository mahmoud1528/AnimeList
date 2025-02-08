package com.example.animelistapi.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animelistapi.data.model.resp.Media
import com.example.animelistapi.data.repository.iListRepository
import kotlinx.coroutines.launch

class AnimeDetailViewModel(private val animeDetailRepository: iListRepository) : ViewModel(){

    var animeDetail = listOf<Media>()
    suspend fun getAnimeList(){
        val response = animeDetailRepository.getAnimeList()
        if (response.isSuccessful){
           animeDetail = response.body()?.data?.Page?.media!!
        }
    }

    init {
        viewModelScope.launch {
            Log.d("GETGET", "getAnimeDetail: ${animeDetailRepository.getAnimeDetails(1).body()}")
        }
    }
}