package com.example.animelistapi.data.api

import com.example.animelistapi.data.model.req.AnimeRequest
import com.example.animelistapi.data.model.resp.AnimeDetailsResponse
import com.example.animelistapi.data.model.resp.AnimeResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface iApiService {
    @POST("/")
    suspend fun queryAnimeApi(@Body reqAnimeDetail: AnimeRequest): Response<AnimeResponse>
    @POST("/")
    suspend fun getAnimeDetails(@Body animeDetailsRequest: AnimeRequest): Response<AnimeDetailsResponse>
}
