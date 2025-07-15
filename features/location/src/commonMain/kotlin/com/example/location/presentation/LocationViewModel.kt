package com.example.location.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.location.interactors.LocationInteractor
import com.example.location.mappers.LocationUiMapper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class LocationViewModel(
    private val interactor: LocationInteractor,
    private val mapper: LocationUiMapper
) : ViewModel() {

    private val locationsFlow = interactor.getLocations()

    private val _uiState = MutableStateFlow<LocationUiState>(LocationUiState.Loading)
    val uiState: StateFlow<LocationUiState> get() = _uiState

    init {
        collectLocations()
    }

    private fun collectLocations() {
        viewModelScope.launch {
            locationsFlow
                .onStart { _uiState.value = LocationUiState.Loading }
                .catch { e -> _uiState.value = LocationUiState.Error(e.message.orEmpty()) }
                .collect { result ->
                    result.onSuccess { list ->
                        _uiState.value = LocationUiState.Success(list.map { mapper.mapToUiLocation(it) })
                    }.onFailure { e ->
                        _uiState.value = LocationUiState.Error(e.message.orEmpty())
                    }
                }
        }
    }
}