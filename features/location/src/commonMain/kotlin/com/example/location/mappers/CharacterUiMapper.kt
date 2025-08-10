package com.example.location.mappers

import com.example.location.models.Character
import com.example.location.models.items.CharacterItemUi

class CharacterUiMapper {
    fun mapToCharacter(domain: Character) = CharacterItemUi(
        id = domain.id ?: 0L,
        name = domain.name.orEmpty(),
        species = domain.species.orEmpty(),
        status = domain.status.orEmpty(),
        gender = domain.gender.orEmpty(),
        image = domain.image.orEmpty()
    )
}