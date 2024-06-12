package com.example.cleancodearchitecture.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.cleancodearchitecture.presentation.state.CharacterState

@Composable
fun CharacterScreen(characterState: CharacterState) {
    when {
        characterState.onLoading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        !characterState.onError.isNullOrEmpty() -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = characterState.onError.toString())
            }
        }

        !characterState.character.isNullOrEmpty() -> {
            LazyColumn {
                items(characterState.character) {
                    CharacterItem(character = it)
                }
            }
        }
    }
}