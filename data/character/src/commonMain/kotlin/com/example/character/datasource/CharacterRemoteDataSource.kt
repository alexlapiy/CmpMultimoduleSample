package com.example.character.datasource

import com.example.rickandmortyapi.apis.character.CharacterApi
import com.example.rickandmortyapi.model.character.CharacterDto

internal class CharacterRemoteDataSource(
    private val characterApi: CharacterApi
) {
    suspend fun getCharactersByIds(ids: List<Long>): Result<List<CharacterDto>> {
        return characterApi.getCharactersByIds(ids)
    }
}
