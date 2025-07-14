package com.example.location.datasource

import com.example.rickandmortyapi.apis.location.LocationApi
import com.example.rickandmortyapi.model.location.LocationDto

internal class LocationRemoteDatasource(
    private val locationApi: LocationApi
) {
    suspend fun getLocations(): List<LocationDto> {
        val result = locationApi.getAllLocations()
        return result.getOrNull() ?: emptyList()
    }
}