package com.example.expressoesnumericas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.example.expressoesnumericas.ui.screens.HomeScreen
import com.example.expressoesnumericas.ui.screens.PrivacyScreen
import com.example.expressoesnumericas.ui.screens.TermsScreen
import com.example.expressoesnumericas.ui.theme.ExpressoesNumericasTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            ExpressoesNumericasTheme {


                var telaAtual by remember {
                    mutableStateOf("home")
                }


                when (telaAtual) {


                    "home" -> {

                        HomeScreen(
                            onTermsClick = {
                                telaAtual = "terms"
                            },
                            onPrivacyClick = {
                                telaAtual = "privacy"
                            }
                        )

                    }


                    "terms" -> {

                        TermsScreen(
                            onBackClick = {
                                telaAtual = "home"
                            }
                        )

                    }


                    "privacy" -> {

                        PrivacyScreen(
                            onBackClick = {
                                telaAtual = "home"
                            }
                        )

                    }

                }


            }

        }

    }

}