package com.example.location.di

import com.example.location.mappers.CharacterUiMapper
import com.example.location.presentation.character.CharactersViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val characterFeatureModule = module {
    factoryOf(::CharacterUiMapper)
    viewModelOf(::CharactersViewModel)
}