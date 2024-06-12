package com.example.cleancodearchitecture.presentation.navigation

sealed class Screens(val route: String) {

    object CharacterScreen : Screens("Character_Screen")
}