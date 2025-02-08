package com.example.animelistapi.data.repository

import com.example.animelistapi.data.model.resp.AnimeDetailsResponse
import com.example.animelistapi.data.model.resp.AnimeResponse
import retrofit2.Response

interface iListRepository {
    suspend fun getAnimeList(): Response<AnimeResponse>
    suspend fun getAnimeDetails(id: Int): Response<AnimeDetailsResponse>
}