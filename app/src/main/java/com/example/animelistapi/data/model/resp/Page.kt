package com.example.animelistapi.data.model.resp


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Page(
    @SerialName("media")
    val media: List<Media>
)