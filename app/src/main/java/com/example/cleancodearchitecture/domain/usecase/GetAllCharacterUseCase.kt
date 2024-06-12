package com.example.cleancodearchitecture.domain.usecase

import com.example.cleancodearchitecture.domain.repository.CharactersRepository
import javax.inject.Inject

class GetAllCharacterUseCase @Inject constructor(private val characterRepository: CharactersRepository) {

    operator fun invoke() = characterRepository.getAllCharacters()

}