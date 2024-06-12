package com.example.cleancodearchitecture.data.repository

import com.example.cleancodearchitecture.core.common.Resource
import com.example.cleancodearchitecture.data.api.CharacterApi
import com.example.cleancodearchitecture.data.mapper.toDomainCharacter
import com.example.cleancodearchitecture.domain.model.Character
import com.example.cleancodearchitecture.domain.repository.CharactersRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@ViewModelScoped
class CharacterRepositoryImpl @Inject constructor(private val characterApi: CharacterApi) : CharactersRepository {
    override fun getAllCharacters(): Flow<Resource<List<Character>>> = flow {
    emit(Resource.Loading())
        val result = characterApi.getAllCharacters().map {
            it.toDomainCharacter()
        }
        emit(Resource.Success(result))

        }.flowOn(Dispatchers.IO)
        .catch {
            emit(Resource.Error(it.message.toString()))
        }
}
