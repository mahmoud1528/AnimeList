package com.example.animelistapi.data.repository

import com.example.animelistapi.data.api.iApiService
import com.example.animelistapi.data.model.resp.AnimeResponse
import retrofit2.Response

class iListRepositoryImpl(private val apis: iApiService): iListRepository {
    override suspend fun getAnimeDetails(): Response<AnimeResponse> {

        return apis.queryAnimeApi()
    }

}