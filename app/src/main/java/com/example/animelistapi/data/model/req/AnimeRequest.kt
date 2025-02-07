package com.example.animelistapi.data.model.req


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AnimeRequest(
    @SerialName("query")
    val query: String,
    @SerialName("variables")
    val variables: Variables
)