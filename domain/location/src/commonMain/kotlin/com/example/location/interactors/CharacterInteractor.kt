package com.example.location.interactors

import com.example.location.models.Character
import com.example.location.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow

class CharacterInteractor(
    private val characterRepository: CharacterRepository
) {

    fun getCharactersByIds(ids: List<Long>): Flow<Result<List<Character>>> = characterRepository.getCharactersByIds(ids)
}