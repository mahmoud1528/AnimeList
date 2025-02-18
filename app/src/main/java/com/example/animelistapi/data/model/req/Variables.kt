package com.example.animelistapi.data.model.req


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Variables(
    @SerialName("perPage")
    val perPage: Int
)