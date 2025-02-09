package com.example.animelistapi.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.animelistapi.data.model.resp.Media
import com.example.animelistapi.data.model.resp.MediaX
import com.example.animelistapi.data.repository.iListRepository

class AnimeDetailsViewModel(private val animeDetailsRepository: iListRepository):ViewModel() {

    var animeDetail = listOf<MediaX>()
    suspend fun getAnimeDetails(id:Int){
        val response = animeDetailsRepository.getAnimeDetails(id)
        if (response.isSuccessful){
            animeDetail = listOf(response.body()?.data?.Media!!)
        }
    }

}