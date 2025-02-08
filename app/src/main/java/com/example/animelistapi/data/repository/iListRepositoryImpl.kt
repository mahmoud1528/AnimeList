package com.example.animelistapi.data.repository

import com.example.animelistapi.data.api.iApiService
import com.example.animelistapi.data.model.req.AnimeRequest
import com.example.animelistapi.data.model.resp.AnimeDetailsResponse
import com.example.animelistapi.data.model.resp.AnimeResponse
import retrofit2.Response

class iListRepositoryImpl(private val apis: iApiService): iListRepository {
    override suspend fun getAnimeList(): Response<AnimeResponse> {
        return apis.queryAnimeApi(AnimeRequest(
            query = "query GetAnimeList " +
                    "{ Page(perPage: 20) " +
                    "{ media { id title { romaji english native }" +
                    " coverImage { large medium color }" +
                    " description(asHtml: true)" +
                    " averageScore meanScore format episodes duration status season seasonYear popularity favourites rankings { id rank type format year season allTime } } } }",
        ))
    }

    override suspend fun getAnimeDetails(id: Int): Response<AnimeDetailsResponse> {
        return apis.getAnimeDetails(AnimeRequest(
            query = "query GetAnimeDetails " +
                    "{ Media(id: $id) " +
                    "{ id title { romaji english native }" +
                    " coverImage { large medium color }" +
                    " description(asHtml: true)" +
                    " averageScore meanScore format episodes duration status season seasonYear popularity favourites rankings { id rank type format year season allTime } } }",
        ))
    }


}