package com.example.character.di

import com.example.character.mappers.CharacterUiMapper
import com.example.character.presentation.CharactersViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val characterFeatureModule = module {
    factoryOf(::CharacterUiMapper)
    viewModelOf(::CharactersViewModel)
}
