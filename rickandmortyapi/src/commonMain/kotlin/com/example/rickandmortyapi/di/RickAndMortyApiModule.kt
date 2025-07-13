package com.example.rickandmortyapi.di

import com.example.rickandmortyapi.apis.location.LocationApi
import com.example.rickandmortyapi.apis.location.LocationApiImpl
import org.koin.dsl.module

val rickAndMortyApiModule = module {
    single<LocationApi> { LocationApiImpl(get()) }
}