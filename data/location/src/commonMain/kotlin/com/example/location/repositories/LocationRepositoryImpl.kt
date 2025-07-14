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

    override fun getLocations(): Flow<Result<List<Location>>> = flow {
        try {
            val result = locationRemoteDatasource.getLocations().getOrThrow()
            val locations = result.map {
                mapper.mapToLocation(it)
            }
            emit(Result.success(locations))
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }
}