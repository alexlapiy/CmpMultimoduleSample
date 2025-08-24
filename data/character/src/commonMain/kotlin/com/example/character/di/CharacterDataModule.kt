package com.example.character.di

import com.example.character.datasource.CharacterRemoteDataSource
import com.example.character.mappers.CharacterDataMapper
import com.example.character.repositories.CharacterRepositoryImpl
import com.example.character.repository.CharacterRepository
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val characterDataModule = module {
    factoryOf(::CharacterRemoteDataSource)
    factoryOf(::CharacterDataMapper)
    single<CharacterRepository> {
        CharacterRepositoryImpl(
            characterRemoteDataSource = get(),
            characterDataMapper = get()
        )
    }
}
