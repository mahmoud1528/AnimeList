package com.example.animelistapi.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.animelistapi.data.model.resp.Media
import com.example.animelistapi.data.model.resp.MediaX
import com.example.animelistapi.data.repository.iListRepository

class AnimeDetailsViewModel(private val animeDetailsRepository: iListRepository):ViewModel() {

    private var _animeDetail = MutableLiveData<MediaX>()
    var animeDetail : LiveData<MediaX> = _animeDetail
    suspend fun getAnimeDetails(id:Int){
        val response = animeDetailsRepository.getAnimeDetails(id)
        if (response.isSuccessful){
            _animeDetail.value = response.body()?.data?.Media
        }
    }

}