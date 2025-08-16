package com.example.rickandmortyapi.apis.character

import com.example.rickandmortyapi.ApiConstants
import com.example.rickandmortyapi.model.character.CharacterDto
import io.github.aakira.napier.Napier
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class CharacterApiImpl(
    private val client: HttpClient
) : CharacterApi {
    override suspend fun getCharactersByIds(ids: List<Long>): Result<List<CharacterDto>> {
        return try {
            val idsString = ids.joinToString(",")
            val response = client.get("${ApiConstants.BASE_URL}/character/$idsString")
                .body<List<CharacterDto>>()

            Result.success(response)
        } catch (e: Exception) {
            Napier.e(e.message.orEmpty())
            Result.failure(e)
        }
    }
}