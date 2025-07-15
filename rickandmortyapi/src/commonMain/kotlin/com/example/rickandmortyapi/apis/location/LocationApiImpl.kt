package com.example.rickandmortyapi.apis.location

import com.example.rickandmortyapi.ApiConstants
import com.example.rickandmortyapi.model.location.LocationDto
import com.example.rickandmortyapi.model.location.LocationResponse
import io.github.aakira.napier.Napier
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

internal class LocationApiImpl(
    private val client: HttpClient
) : LocationApi {
    override suspend fun getAllLocations(): Result<List<LocationDto>> {
        return try {
            val response = client.get("${ApiConstants.BASE_URL}/location")
                .body<LocationResponse>()

            Result.success(response.results)
        } catch (e: Exception) {
            Napier.e(e.message.orEmpty())
            Result.failure(e)
        }
    }
}