package com.example.character.repositories

import com.example.character.datasource.CharacterRemoteDataSource
import com.example.character.mappers.CharacterDataMapper
import com.example.character.models.Character
import com.example.character.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class CharacterRepositoryImpl(
    private val characterRemoteDataSource: CharacterRemoteDataSource,
    private val characterDataMapper: CharacterDataMapper
) : CharacterRepository {
    override fun getCharactersByIds(ids: List<Long>): Flow<Result<List<Character>>> = flow {
        try {
            val result = characterRemoteDataSource.getCharactersByIds(ids).getOrThrow()
            val characters = result.map {
                characterDataMapper.mapToCharacter(it)
            }
            emit(Result.success(characters))
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }
}
