package com.example.expressoesnumericas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.expressoesnumericas.ui.screens.HomeScreen
import com.example.expressoesnumericas.ui.theme.ExpressoesNumericasTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            ExpressoesNumericasTheme {

                HomeScreen()

            }
        }
    }
}