package com.example.rickandmortyapi.model.character

import kotlinx.serialization.Serializable

@Serializable
data class CharacterDto(
    val id: Long?,
    val name: String?,
    val species: String?,
    val status: String?,
    val gender: String?,
    val image: String?,
)
