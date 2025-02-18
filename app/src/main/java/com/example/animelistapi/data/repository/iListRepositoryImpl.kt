package com.example.animelistapi.data.repository

import com.example.animelistapi.data.api.iApiService
import com.example.animelistapi.data.model.req.AnimeRequest
import com.example.animelistapi.data.model.resp.AnimeDetailsResponse
import com.example.animelistapi.data.model.resp.AnimeResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

class iListRepositoryImpl(private val apis: iApiService): iListRepository {
    //get static data
//    override suspend fun getAnimeList(): Response<AnimeResponse> {
//        return apis.queryAnimeApi(AnimeRequest(
//            query = "query GetAnimeList " +
//                    "{ Page(perPage: 50) " +
//                    "{ media { id title { romaji english native }" +
//                    " coverImage { large medium color }" +
//                    " description(asHtml: true)" +
//                    " averageScore meanScore format episodes duration " +
//                    "status season seasonYear popularity " +
//                    "favourites rankings { id rank type format year season allTime } } } }"
//        ))
//    }

    // get all data
    override suspend fun getAnimeList(): Response<AnimeResponse> {
    return apis.queryAnimeApi(AnimeRequest(
        query = "query GetAnimeList { Page(page: 1, perPage: 500) " +
                "{ pageInfo { hasNextPage currentPage } media " +
                "{ id title { romaji } coverImage " +
                "{ large}" +
                " averageScore episodes " +
                "  } } }"

    ))
    }

    override suspend fun getAnimeDetails(id: Int): Response<AnimeDetailsResponse> {
        return apis.getAnimeDetails(AnimeRequest(
            query = "query GetAnimeDetails " +
                    "{ Media(id: $id) " +
                    "{ id title { romaji english }" +
                    " coverImage { medium }" +
                    " description(asHtml: true)" +
                    " format " +
                    "status season seasonYear " +
                    "} }",
        ))
    }


}