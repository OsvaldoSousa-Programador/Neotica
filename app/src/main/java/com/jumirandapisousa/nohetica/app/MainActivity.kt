package com.jumirandapisousa.nohetica.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.*
import com.jumirandapisousa.nohetica.app.ui.screens.HomeScreen
import com.jumirandapisousa.nohetica.app.ui.screens.PrivacyScreen
import com.jumirandapisousa.nohetica.app.ui.screens.TermsScreen
import com.jumirandapisousa.nohetica.app.ui.theme.ExpressoesNumericasTheme
import com.jumirandapisousa.nohetica.app.ui.theme.ProvideDimens

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val windowSizeClass = calculateWindowSizeClass(this)
            
            var fontScale by remember { mutableStateOf(1f) }

            ExpressoesNumericasTheme(fontScale = fontScale) {
                ProvideDimens(
                    windowWidthSizeClass = windowSizeClass.widthSizeClass,
                    fontScale = fontScale
                ) {
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
                                },
                                fontScale = fontScale,
                                onFontScaleChange = { fontScale = it }
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
}
