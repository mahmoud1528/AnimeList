package com.example.animelistapi.data.repository

import com.example.animelistapi.data.model.resp.AnimeResponse
import retrofit2.Response

interface iListRepository {
    suspend fun getAnimeDetails(): Response<AnimeResponse>
}