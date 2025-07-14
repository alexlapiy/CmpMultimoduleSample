package com.example.location.mappers

import com.example.location.models.Location
import com.example.rickandmortyapi.model.location.LocationDto

internal class LocationDataMapper {
    fun mapToLocation(locationDto: LocationDto): Location {
        return Location(
            id = locationDto.id,
            name = locationDto.name,
            type = locationDto.type,
            dimension = locationDto.dimension,
            url = locationDto.url,
        )
    }
}