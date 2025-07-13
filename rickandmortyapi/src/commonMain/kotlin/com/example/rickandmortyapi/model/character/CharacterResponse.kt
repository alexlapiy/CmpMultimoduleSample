package com.example.rickandmortyapi.model.character

import kotlinx.serialization.Serializable

@Serializable
data class CharacterResponse(
    val results: List<CharacterDto>?
)