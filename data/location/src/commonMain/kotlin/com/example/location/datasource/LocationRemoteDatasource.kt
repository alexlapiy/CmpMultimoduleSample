package com.example.location.datasource

import com.example.rickandmortyapi.apis.location.LocationApi
import com.example.rickandmortyapi.model.location.LocationDto

internal class LocationRemoteDatasource(
    private val locationApi: LocationApi
) {
    suspend fun getLocations(): Result<List<LocationDto>> {
        return locationApi.getAllLocations()
    }
}