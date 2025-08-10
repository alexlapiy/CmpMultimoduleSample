package com.example.location.interactors

import com.example.location.models.Location
import com.example.location.repository.LocationRepository
import kotlinx.coroutines.flow.Flow

class LocationInteractor(
    private val repository: LocationRepository
) {

    fun getLocations(): Flow<Result<List<Location>>> = repository.getLocations()
}