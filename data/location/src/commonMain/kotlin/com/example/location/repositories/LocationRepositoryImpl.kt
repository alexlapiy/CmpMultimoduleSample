package com.example.location.repositories

import com.example.location.datasource.LocationRemoteDatasource
import com.example.location.mappers.LocationDataMapper
import com.example.location.models.Location
import com.example.location.repository.LocationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class LocationRepositoryImpl(
    private val locationRemoteDatasource: LocationRemoteDatasource,
    private val mapper: LocationDataMapper
) : LocationRepository {

    override fun getLocations(): Flow<List<Location>> = flow {
        val result = locationRemoteDatasource.getLocations()
        val locations = result.map {
            mapper.mapToLocation(it)
        }
        emit(locations)
    }
}