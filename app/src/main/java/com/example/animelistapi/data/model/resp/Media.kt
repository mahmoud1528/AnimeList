package com.example.animelistapi.data.model.resp


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Media(
    @SerialName("averageScore")
    val averageScore: Int,
    @SerialName("coverImage")
    val coverImage: CoverImage,
    @SerialName("description")
    val description: String,
    @SerialName("duration")
    val duration: Int,
    @SerialName("episodes")
    val episodes: Int,
    @SerialName("favourites")
    val favourites: Int,
    @SerialName("format")
    val format: String,
    @SerialName("id")
    val id: Int,
    @SerialName("meanScore")
    val meanScore: Int,
    @SerialName("popularity")
    val popularity: Int,
    @SerialName("rankings")
    val rankings: List<Ranking>,
    @SerialName("season")
    val season: String,
    @SerialName("seasonYear")
    val seasonYear: Int,
    @SerialName("status")
    val status: String,
    @SerialName("title")
    val title: Title
)