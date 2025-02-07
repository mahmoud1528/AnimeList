package com.example.animelistapi.data.api

import com.example.animelistapi.data.model.req.AnimeRequest
import com.example.animelistapi.data.model.req.Variables
import com.example.animelistapi.data.model.resp.AnimeResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface iApiService {
    @POST("/")
    suspend fun queryAnimeApi(@Body reqAnimeDetail: AnimeRequest = AnimeRequest(
        query = "query GetAnimeList(\$perPage: Int!) " +
                "{ Page(perPage: \$perPage) " +
                "{ media { id title { romaji english native }" +
                " coverImage { large medium color }" +
                " description(asHtml: true)" +
                " averageScore meanScore format episodes duration status season seasonYear popularity favourites rankings { id rank type format year season allTime } } } }",
        variables = Variables(20)
    )): Response<AnimeResponse>
}
