package com.example.animelistapi.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animelistapi.data.model.resp.Media
import com.example.animelistapi.data.repository.iListRepository
import kotlinx.coroutines.launch

class AnimeListViewModel(private val animeListRepository: iListRepository) : ViewModel(){

    var animeList = listOf<Media>()
    suspend fun getAnimeList(){
        val response = animeListRepository.getAnimeList()
        if (response.isSuccessful){
            animeList = response.body()?.data?.Page?.media!!
        }
    }

//    init {
//        viewModelScope.launch {
//            Log.d("GETGET", "getAnimeDetail: ${animeListRepository.getAnimeDetails(1).body()}")
//        }
//    }
}