package com.example.animelistapi.data.api

import com.example.animelistapi.data.model.req.AnimeRequest
import com.example.animelistapi.data.model.resp.AnimeResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

private val query: String
    get() = """
        query GetAnimeList {
            Page(perPage: 20) {
                media {
                    id
                    title {
                        romaji
                        english
                        native
                    }
                    coverImage {
                        large
                        medium
                        color
                    }
                    description(asHtml: true)
                    averageScore
                    meanScore
                    format
                    episodes
                    duration
                    status
                    season
                    seasonYear
                    popularity
                    favourites
                    rankings {
                        id
                        rank
                        type
                        format
                        year
                        season
                        allTime
                    }
                }
            }
        }
    """

interface iApiService {
    @POST("/")
    suspend fun queryAnimeApi(@Body reqAnimeDetail: AnimeRequest = AnimeRequest(
        query = query,
    )): Response<AnimeResponse>
}
