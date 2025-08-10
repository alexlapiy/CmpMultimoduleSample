package com.example.rickandmortyapi.apis.character

import com.example.rickandmortyapi.model.character.CharacterDto

interface CharacterApi {
    suspend fun getCharactersByIds(ids: List<Long>): Result<List<CharacterDto>>
}