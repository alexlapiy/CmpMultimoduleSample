package com.example.rickandmortyapi.apis.location

import com.example.rickandmortyapi.model.location.LocationDto

interface LocationApi {
    suspend fun getAllLocations(): Result<List<LocationDto>>
}