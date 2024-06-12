package com.example.cleancodearchitecture.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleancodearchitecture.core.common.Resource
import com.example.cleancodearchitecture.domain.usecase.GetAllCharacterUseCase
import com.example.cleancodearchitecture.presentation.state.CharacterState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class CharacterViewModel @Inject constructor(private val useCase: GetAllCharacterUseCase) : ViewModel() {

    private val _characterState = MutableStateFlow(CharacterState())
    val characterState = _characterState.asStateFlow()


    init {
        getAllCharacter()
    }

    private fun getAllCharacter() {
        useCase().onEach {
            when (it) {
                is Resource.Error -> {
                    _characterState.value = CharacterState().copy(onError = it.message)
                }

                is Resource.Loading -> {
                    _characterState.value = CharacterState().copy(onLoading = true)
                }

                is Resource.Success -> {
                    _characterState.value = CharacterState().copy(character = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }


}