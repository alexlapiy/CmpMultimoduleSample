package com.example.location.interactors

import com.example.location.models.Character
import com.example.location.repository.CharacterRepository
import io.github.aakira.napier.Napier
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CharacterInteractor(
    private val characterRepository: CharacterRepository
) {

    fun getCharactersByIds(ids: List<Long>): Flow<Result<List<Character>>> = characterRepository.getCharactersByIds(ids)
    
    fun getCharactersByUrls(residentUrls: List<String>): Flow<Result<List<Character>>> {
        val characterIds = extractCharacterIds(residentUrls)
        return if (characterIds.isNotEmpty()) {
            getCharactersByIds(characterIds)
        } else {
            flow { emit(Result.success(emptyList())) }
        }
    }
    
    private fun extractCharacterIds(urls: List<String>): List<Long> {
        return urls.mapNotNull { url ->
            try {
                // Extract the character ID from the URL "https://rickandmortyapi.com/api/character/1"
                val characterIdPattern = "/character/(\\d+)".toRegex()
                val matchResult = characterIdPattern.find(url)
                matchResult?.groupValues?.getOrNull(1)?.toLongOrNull()
            } catch (e: Exception) {
                Napier.e { e.message.orEmpty() }
                null
            }
        }
    }
}