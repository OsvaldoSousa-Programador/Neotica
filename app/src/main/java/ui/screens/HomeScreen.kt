package com.example.expressoesnumericas.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.expressoesnumericas.ui.components.AppBodyText
import com.example.expressoesnumericas.ui.components.AppButton
import com.example.expressoesnumericas.ui.components.AppCard
import com.example.expressoesnumericas.ui.components.AppLogo
import com.example.expressoesnumericas.ui.components.AppTitleText
import com.example.expressoesnumericas.ui.theme.Dimens
import ui.theme.ExpressoesNumericasTheme
import com.example.expressoesnumericas.logic.gerarExpressaoNumerica

@Composable
fun HomeScreen() {

    var expressaoGerada by remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        // Logo
        AppLogo(
            modifier = Modifier.align(Alignment.TopCenter)
        )

        // Textos iniciais
        if (expressaoGerada.isEmpty()) {

            AppTitleText(
                text = "Treine seus cálculos!",
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(
                        top = Dimens.Home.TitleTop,
                        start = Dimens.Home.HorizontalPadding,
                        end = Dimens.Home.HorizontalPadding
                    )
            )

            AppBodyText(
                text = "O botão abaixo cria uma expressão\npara você resolver!",
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(
                        top = Dimens.Home.DescriptionTop,
                        start = Dimens.Home.HorizontalPadding,
                        end = Dimens.Home.HorizontalPadding
                    )
            )
        }

        // Card da expressão
        if (expressaoGerada.isNotEmpty()) {

            AppCard(
                expression = expressaoGerada,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(Dimens.Card.Padding)
            )

        }

        // Botão principal
        AppButton(
            text = if (expressaoGerada.isEmpty()) {
                "Gerar Expressão"
            } else {
                "Resolver Expressão"
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = Dimens.Home.ButtonBottom),
            onClick = {

                if (expressaoGerada.isEmpty()) {

                    expressaoGerada = gerarExpressaoNumerica()

                } else {

                    // Aqui futuramente chamaremos o resolvedor

                }

            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {

    ExpressoesNumericasTheme {

        HomeScreen()

    }

}