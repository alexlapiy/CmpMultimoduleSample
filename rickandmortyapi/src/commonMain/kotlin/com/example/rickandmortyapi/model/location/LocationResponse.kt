package com.example.rickandmortyapi.model.location

import kotlinx.serialization.Serializable

@Serializable
data class LocationResponse(
    val results: List<LocationDto>?
)