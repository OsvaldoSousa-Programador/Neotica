package com.example.expressoesnumericas.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.expressoesnumericas.R
import com.example.expressoesnumericas.logic.gerarExpressaoNumerica
import com.example.expressoesnumericas.ui.components.AppBodyText
import com.example.expressoesnumericas.ui.components.AppButton
import com.example.expressoesnumericas.ui.components.AppCard
import com.example.expressoesnumericas.ui.components.AppLogo
import com.example.expressoesnumericas.ui.components.AppTitleText
import com.example.expressoesnumericas.ui.theme.Dimens
import com.example.expressoesnumericas.ui.theme.ExpressoesNumericasTheme
import com.example.expressoesnumericas.ui.theme.NoeBlue
import com.example.expressoesnumericas.ui.theme.NoeOrange

@Composable
fun HomeScreen() {

    var expressaoGerada by remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        // Fundo decorativo (apenas na tela inicial)
        if (expressaoGerada.isEmpty()) {

            Image(
                painter = painterResource(id = R.drawable.elementosdesignbg),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )

        }

        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = Dimens.Home.LogoTop),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            AppLogo()

            if (expressaoGerada.isEmpty()) {

                Spacer(
                    modifier = Modifier.height(Dimens.Home.LogoToTitle)
                )

                AppTitleText(
                    text = "Treine seus cálculos!"
                )

                Spacer(
                    modifier = Modifier.height(Dimens.Home.TitleToDescription)
                )

                AppBodyText(
                    text = "O botão abaixo cria uma expressão\npara você resolver!"
                )

                Spacer(
                    modifier = Modifier.height(Dimens.Home.DescriptionToButton)
                )

                AppButton(
                    text = "Gerar Expressão",
                    backgroundColor = NoeBlue,
                    onClick = {
                        expressaoGerada = gerarExpressaoNumerica()
                    }
                )

            } else {

                Spacer(
                    modifier = Modifier.height(Dimens.Home.LogoToCard)
                )

                AppCard(
                    expression = expressaoGerada,
                    modifier = Modifier.padding(
                        horizontal = Dimens.Card.HorizontalMargin
                    )
                )

                Spacer(
                    modifier = Modifier.height(Dimens.Home.CardToButton)
                )

                AppButton(
                    text = "Resolver Expressão",
                    backgroundColor = NoeOrange,
                    onClick = {

                        // Aqui futuramente chamaremos o resolvedor

                    }
                )

            }

        }

    }

}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {

    ExpressoesNumericasTheme {

        HomeScreen()

    }

}