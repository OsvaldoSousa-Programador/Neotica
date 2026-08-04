package com.example.expressoesnumericas.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.expressoesnumericas.logic.gerarExpressaoNumerica
import com.example.expressoesnumericas.ui.components.AppBodyText
import com.example.expressoesnumericas.ui.components.AppButton
import com.example.expressoesnumericas.ui.components.AppCard
import com.example.expressoesnumericas.ui.components.AppLogo
import com.example.expressoesnumericas.ui.components.AppTitleText
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

        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 169.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            AppLogo()


            if (expressaoGerada.isEmpty()) {


                Spacer(
                    modifier = Modifier.height(84.dp)
                )


                AppTitleText(
                    text = "Treine seus cálculos!"
                )


                Spacer(
                    modifier = Modifier.height(3.dp)
                )


                AppBodyText(
                    text = "O botão abaixo cria uma expressão\npara você resolver!"
                )


                Spacer(
                    modifier = Modifier.height(14.dp)
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
                    modifier = Modifier.height(64.dp)
                )


                AppCard(
                    expression = expressaoGerada,
                    modifier = Modifier.padding(horizontal = 40.dp)
                )


                Spacer(
                    modifier = Modifier.height(86.dp)
                )


                AppButton(
                    text = "Resolver Expressão",
                    backgroundColor = NoeOrange,
                    onClick = {

                        // Resolver futuramente

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