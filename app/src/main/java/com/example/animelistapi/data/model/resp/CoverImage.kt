package com.example.animelistapi.data.model.resp


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoverImage(
    @SerialName("color")
    val color: String,
    @SerialName("large")
    val large: String,
    @SerialName("medium")
    val medium: String
)