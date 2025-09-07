package com.example.character.presentation

import com.example.character.models.items.CharacterItemUi

sealed interface CharactersUiState {
    data object Loading : CharactersUiState
    data class Success(val characters: List<CharacterItemUi>) : CharactersUiState
    data class Error(val message: String) : CharactersUiState
}
