package com.example.location.interactors

import com.example.location.repository.LocationRepository

class LocationInteractor(
    private val repository: LocationRepository
) {

    fun getLocations() = repository.getLocations()
}