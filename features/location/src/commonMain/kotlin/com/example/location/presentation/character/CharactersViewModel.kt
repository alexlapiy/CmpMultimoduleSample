package com.example.location.presentation.character

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.location.interactors.CharacterInteractor
import com.example.location.mappers.CharacterUiMapper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class CharactersViewModel(
    private val interactor: CharacterInteractor,
    private val mapper: CharacterUiMapper
) : ViewModel() {

    private val _uiState = MutableStateFlow<CharactersUiState>(CharactersUiState.Loading)
    val uiState: StateFlow<CharactersUiState> get() = _uiState

    fun loadCharacters(residentUrls: List<String>) {
        if (residentUrls.isEmpty()) {
            _uiState.value = CharactersUiState.Success(emptyList())
            return
        }

        viewModelScope.launch {
            interactor.getCharactersByUrls(residentUrls)
                .onStart { _uiState.value = CharactersUiState.Loading }
                .catch { e -> _uiState.value = CharactersUiState.Error(e.message.orEmpty()) }
                .collect { result ->
                    result.onSuccess { characters ->
                        _uiState.value =
                            CharactersUiState.Success(characters.map { mapper.mapToCharacter(it) })
                    }.onFailure { e ->
                        _uiState.value = CharactersUiState.Error(e.message.orEmpty())
                    }
                }
        }
    }
}