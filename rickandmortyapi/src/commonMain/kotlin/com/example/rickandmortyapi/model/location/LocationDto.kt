package com.example.rickandmortyapi.model.location

import kotlinx.serialization.Serializable


@Serializable
data class LocationDto(
    val id: Long?,
    val name: String?,
    val type: String?,
    val dimension: String?,
    val url: String?,
)