package com.example.cmpmultimodulesample.di

import com.example.core.di.coreModule
import com.example.character.di.characterFeatureModule
import com.example.location.di.dataLocationModule
import com.example.character.di.characterDataModule
import com.example.character.di.characterDomainModule
import com.example.location.di.domainLocationModule
import com.example.location.di.locationFeatureModule
import com.example.rickandmortyapi.di.rickAndMortyApiModule
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin


private val sharedModules = listOf(
    coreModule,
    rickAndMortyApiModule,
    dataLocationModule,
    domainLocationModule,
    locationFeatureModule,
    characterDataModule,
    characterDomainModule,
    characterFeatureModule
)

fun initializeKoin(
    config: (KoinApplication.() -> Unit)? = null,
) {
    startKoin {
        config?.invoke(this)
        modules(sharedModules)
    }
}