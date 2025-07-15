package com.example.location.mappers

import com.example.location.models.Location
import com.example.location.models.items.LocationItemUi

class LocationUiMapper {
    fun mapToUiLocation(domain: Location) = LocationItemUi(
        id = domain.id ?: 0L,
        name = domain.name.orEmpty(),
        type = domain.type.orEmpty(),
        dimension = domain.dimension.orEmpty(),
        url = domain.url.orEmpty()
    )
}