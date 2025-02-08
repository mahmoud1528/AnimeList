package com.example.animelistapi.data.model.resp


import kotlinx.serialization.Serializable

@Serializable
data class AnimeResponse(
    val data: Data
)

@Serializable
data class Data(
    val Page: Page
)

@Serializable
data class Page(
    val media: List<Media>
)

@Serializable
data class Media(
    val id: Int,
    val title: Title,
    val coverImage: CoverImage,
    val description: String,
    val averageScore: Int,
    val meanScore: Int,
    val format: String,
    val episodes: Int,
    val duration: Int,
    val status: String,
    val season: String,
    val seasonYear: Int,
    val popularity: Int,
    val favourites: Int,
    val rankings: List<Ranking>
)

@Serializable
data class Title(
    val romaji: String,
    val english: String,
    val native: String
)

@Serializable
data class CoverImage(
    val large: String,
    val medium: String,
    val color: String
)

@Serializable
data class Ranking(
    val id: Int,
    val rank: Int,
    val type: String,
    val format: String,
    val year: Int?,
    val season: String,
    val allTime: Boolean?
)