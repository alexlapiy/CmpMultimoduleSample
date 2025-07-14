package com.example.location.repository

import com.example.location.models.Location
import kotlinx.coroutines.flow.Flow

interface LocationRepository {
    fun getLocations(): Flow<List<Location>>
}