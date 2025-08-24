package com.example.character.di

import com.example.character.interactors.CharacterInteractor
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val characterDomainModule = module {
    factoryOf(::CharacterInteractor)
}
