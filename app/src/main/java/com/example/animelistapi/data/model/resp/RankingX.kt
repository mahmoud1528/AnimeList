package com.example.animelistapi.data.model.resp


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RankingX(
    @SerialName("allTime")
    val allTime: Boolean,
    @SerialName("format")
    val format: String,
    @SerialName("id")
    val id: Int,
    @SerialName("rank")
    val rank: Int,
    @SerialName("season")
    val season: String,
    @SerialName("type")
    val type: String,
    @SerialName("year")
    val year: Int
)