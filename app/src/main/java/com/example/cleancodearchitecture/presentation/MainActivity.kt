package com.example.cleancodearchitecture.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.cleancodearchitecture.presentation.navigation.Navigation
import com.example.cleancodearchitecture.presentation.ui.theme.CleanCodeArchitectureTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CleanCodeArchitectureTheme {
            Navigation()
            }
        }
    }
}
