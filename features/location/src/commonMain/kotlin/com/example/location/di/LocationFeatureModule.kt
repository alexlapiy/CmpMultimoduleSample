package com.example.location.di

import com.example.location.mappers.LocationUiMapper
import com.example.location.presentation.LocationViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val locationFeatureModule = module {
    factoryOf(::LocationUiMapper)
    viewModelOf(::LocationViewModel)
}