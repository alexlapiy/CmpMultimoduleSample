package com.example.location.presentation

import com.example.location.models.items.LocationItemUi

sealed interface LocationUiState {
    data object Loading : LocationUiState
    data class Success(val locations: List<LocationItemUi>) : LocationUiState
    data class Error(val message: String) : LocationUiState
}