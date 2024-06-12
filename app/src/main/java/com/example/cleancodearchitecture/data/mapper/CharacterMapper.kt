package com.example.cleancodearchitecture.data.mapper

import com.example.cleancodearchitecture.data.dto.CharacterDto
import com.example.cleancodearchitecture.domain.model.Character

fun CharacterDto.toDomainCharacter(): Character {
    return Character(
        id,
        name,
        image,
        actor
    )
}