package com.example.location.di

import com.example.location.datasource.CharacterRemoteDataSource
import com.example.location.mappers.CharacterDataMapper
import com.example.location.repositories.CharacterRepositoryImpl
import com.example.location.repository.CharacterRepository
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val characterLocationModule = module {
    factoryOf(::CharacterRemoteDataSource)
    factoryOf(::CharacterDataMapper)
    single<CharacterRepository> {
        CharacterRepositoryImpl(
            characterRemoteDataSource = get(),
            characterDataMapper = get()
        )
    }
}