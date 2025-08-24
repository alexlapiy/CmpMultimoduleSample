package com.example.character.repository

import com.example.character.models.Character
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    fun getCharactersByIds(ids: List<Long>): Flow<Result<List<Character>>>
}
