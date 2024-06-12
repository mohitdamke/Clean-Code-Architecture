package com.example.cleancodearchitecture.domain.repository

import com.example.cleancodearchitecture.core.common.Resource
import com.example.cleancodearchitecture.domain.model.Character
import kotlinx.coroutines.flow.Flow

interface CharactersRepository {

    fun getAllCharacters(): Flow<Resource<List<Character>>>
}