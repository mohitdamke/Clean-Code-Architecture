package com.example.cleancodearchitecture.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cleancodearchitecture.presentation.CharacterScreen
import com.example.cleancodearchitecture.presentation.viewmodel.CharacterViewModel


@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.CharacterScreen.route) {
        composable(Screens.CharacterScreen.route) {

            val characterViewModel = hiltViewModel<CharacterViewModel>()
            val characterState = characterViewModel.characterState.collectAsState().value
            CharacterScreen(characterState = characterState)
        }
    }
}