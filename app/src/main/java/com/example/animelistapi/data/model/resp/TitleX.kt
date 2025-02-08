package com.example.animelistapi.data.model.resp


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TitleX(
    @SerialName("english")
    val english: String,
    @SerialName("native")
    val native: String,
    @SerialName("romaji")
    val romaji: String
)