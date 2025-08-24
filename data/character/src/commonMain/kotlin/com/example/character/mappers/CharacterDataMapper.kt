package com.example.character.mappers

import com.example.character.models.Character
import com.example.rickandmortyapi.model.character.CharacterDto

internal class CharacterDataMapper {
    fun mapToCharacter(characterDto: CharacterDto): Character {
        return Character(
            id = characterDto.id,
            name = characterDto.name,
            species = characterDto.species,
            status = characterDto.status,
            gender = characterDto.gender,
            image = characterDto.image,
        )
    }
}
