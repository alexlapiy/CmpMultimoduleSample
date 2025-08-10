package com.example.location.presentation.character

import com.example.location.models.items.CharacterItemUi

interface CharactersUiState {
    data object Loading : CharactersUiState
    data class Success(val characters: List<CharacterItemUi>) : CharactersUiState
    data class Error(val message: String) : CharactersUiState
}