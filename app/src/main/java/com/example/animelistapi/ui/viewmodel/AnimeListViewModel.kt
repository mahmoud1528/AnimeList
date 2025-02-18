package com.example.animelistapi.ui.viewmodel

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animelistapi.data.model.resp.Media
import com.example.animelistapi.data.repository.iListRepository
import kotlinx.coroutines.launch

class AnimeListViewModel(private val animeListRepository: iListRepository) : ViewModel(){

    private var _animeList = MutableLiveData<List<Media>>()
    var animeList : LiveData<List<Media>> =_animeList
    suspend fun getAnimeList(){
        val response = animeListRepository.getAnimeList()
        if (response.isSuccessful){

            _animeList.value = response.body()?.data?.Page?.media
            Log.d("GETGET", "getAnimeList: ${response.body()?.data?.Page?.media?.get(0)}")

        }
    }

//    init {
//        viewModelScope.launch {
//            Log.d("GETGET", "getAnimeDetail: ${animeListRepository.getAnimeDetails(1).body()}")
//        }
//    }
}