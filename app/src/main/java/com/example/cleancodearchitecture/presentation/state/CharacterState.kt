package com.example.cleancodearchitecture.presentation.state

import com.example.cleancodearchitecture.domain.model.Character

data class CharacterState(
    val character: List<Character>? = emptyList(),
    val onError : String? = "",
    val onLoading : Boolean = false

)