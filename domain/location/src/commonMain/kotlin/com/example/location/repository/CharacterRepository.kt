package com.example.location.repository

import com.example.location.models.Character
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    fun getCharactersByIds(ids: List<Long>): Flow<Result<List<Character>>>
}