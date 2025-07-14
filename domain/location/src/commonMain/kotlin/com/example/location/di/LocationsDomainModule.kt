package com.example.location.di

import com.example.location.interactors.LocationInteractor
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainLocationModule = module {
    factoryOf(::LocationInteractor)
}