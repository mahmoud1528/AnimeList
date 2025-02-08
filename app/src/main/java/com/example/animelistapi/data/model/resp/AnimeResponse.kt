package com.example.animelistapi.data.model.resp


import kotlinx.serialization.Serializable

@Serializable
data class AnimeResponse(
    val data: Data
)