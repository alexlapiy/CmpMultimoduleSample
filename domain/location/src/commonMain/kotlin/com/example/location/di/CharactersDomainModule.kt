package com.example.location.di

import com.example.location.interactors.CharacterInteractor
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainCharacterModule = module {
    factoryOf(::CharacterInteractor)
}