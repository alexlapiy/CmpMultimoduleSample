package com.example.location.di

import com.example.location.datasource.LocationRemoteDatasource
import com.example.location.mappers.LocationDataMapper
import com.example.location.repositories.LocationRepositoryImpl
import com.example.location.repository.LocationRepository
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val dataLocationModule = module {
    factoryOf(::LocationRemoteDatasource)
    factoryOf(::LocationDataMapper)
    single<LocationRepository> {
        LocationRepositoryImpl(
            locationRemoteDatasource = get(),
            mapper = get()
        )
    }
}