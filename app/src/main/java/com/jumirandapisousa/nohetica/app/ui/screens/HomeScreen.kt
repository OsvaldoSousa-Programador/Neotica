package com.jumirandapisousa.nohetica.app.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.jumirandapisousa.nohetica.app.R
import com.jumirandapisousa.nohetica.app.logic.gerarExpressaoNumerica
import com.jumirandapisousa.nohetica.app.logic.gerarResolucaoFormatada
import com.jumirandapisousa.nohetica.app.logic.resolverExpressaoCompleta

import com.jumirandapisousa.nohetica.app.ui.components.AppBodyText
import com.jumirandapisousa.nohetica.app.ui.components.AppButton
import com.jumirandapisousa.nohetica.app.ui.components.AppCard
import com.jumirandapisousa.nohetica.app.ui.components.AppLogo
import com.jumirandapisousa.nohetica.app.ui.components.AppTopBar
import com.jumirandapisousa.nohetica.app.ui.components.AppTitleText

import com.jumirandapisousa.nohetica.app.ui.theme.Dimens
import com.jumirandapisousa.nohetica.app.ui.theme.ExpressoesNumericasTheme
import com.jumirandapisousa.nohetica.app.ui.theme.NoeBlue
import com.jumirandapisousa.nohetica.app.ui.theme.NoeOrange
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.alpha



@Composable
fun HomeScreen(
    onTermsClick: () -> Unit,
    onPrivacyClick: () -> Unit,
    fontScale: Float = 1f,
    onFontScaleChange: (Float) -> Unit = {}
) {

    var expressaoGerada by remember {
        mutableStateOf("")
    }

    var resolucaoTexto by remember {
        mutableStateOf("")
    }

    val verticalScrollState = rememberScrollState()
    val horizontalScrollState = rememberScrollState()
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp

    // Efeito para centralizar o scroll automaticamente quando a expressão mudar
    LaunchedEffect(expressaoGerada, resolucaoTexto) {
        // Aguarda um pequeno delay para o layout calcular a nova largura
        kotlinx.coroutines.delay(100)
        if (horizontalScrollState.maxValue > 0) {
            horizontalScrollState.animateScrollTo(horizontalScrollState.maxValue / 2)
        } else {
            horizontalScrollState.scrollTo(0)
        }
    }


    Box(
        modifier = Modifier.fillMaxSize()
    ) {


        // Fundo decorativo somente na tela inicial
        if (expressaoGerada.isEmpty()) {

            Image(
                painter = painterResource(id = R.drawable.bgnoh_inicial),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .scale(1.5f)
                    .alpha(0.7f),
                contentScale = ContentScale.FillWidth
            )

        }


        Column(

            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(verticalScrollState)
                .horizontalScroll(horizontalScrollState)
                .padding(
                    top = Dimens.Home.LogoTop,
                    bottom = Dimens.Home.LogoTop
                )
                .widthIn(min = screenWidth),

            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top

        ) {


            AppLogo()



            // ESTADO 1 - Tela inicial
            if (expressaoGerada.isEmpty()) {


                Spacer(
                    modifier = Modifier.height(
                        Dimens.Home.LogoToTitle
                    )
                )


                AppTitleText(
                    text = "Treine seus cálculos!"
                )


                Spacer(
                    modifier = Modifier.height(
                        Dimens.Home.TitleToDescription
                    )
                )


                AppBodyText(
                    text = "O botão abaixo cria uma expressão\npara você resolver!"
                )


                Spacer(
                    modifier = Modifier.height(
                        Dimens.Home.DescriptionToButton
                    )
                )


                AppButton(

                    text = "Gerar Expressão",

                    backgroundColor = NoeBlue,

                    onClick = {

                        expressaoGerada =
                            gerarExpressaoNumerica()

                    }

                )


            }


            // ESTADO 2 - Expressão gerada
            else if (resolucaoTexto.isEmpty()) {


                Spacer(
                    modifier = Modifier.height(
                        Dimens.Home.LogoToCard
                    )
                )


                AppCard(

                    expression = expressaoGerada,

                    modifier = Modifier
                        .width(screenWidth)
                        .padding(
                            horizontal = Dimens.Card.HorizontalMargin
                        )

                )


                Spacer(
                    modifier = Modifier.height(
                        Dimens.Home.CardToButton
                    )
                )


                AppButton(

                    text = "Resolver Expressão",

                    backgroundColor = NoeOrange,

                    onClick = {


                        val resolucao =
                            resolverExpressaoCompleta(
                                expressaoGerada
                            )


                        resolucaoTexto =
                            gerarResolucaoFormatada(
                                resolucao
                            )

                    }

                )


                Spacer(
                    modifier = Modifier.height(
                        Dimens.Home.BetweenButtons
                    )
                )


                AppButton(

                    text = "Gerar Nova Expressão",

                    backgroundColor = NoeBlue,

                    onClick = {

                        expressaoGerada =
                            gerarExpressaoNumerica()

                    }

                )


            }


            // ESTADO 3 - Resolução
            else {


                Spacer(
                    modifier = Modifier.height(
                        Dimens.Home.LogoToCard
                    )
                )


                AppCard(

                    expression = resolucaoTexto,

                    modifier = Modifier
                        .width(screenWidth)
                        .padding(
                            horizontal = Dimens.Card.HorizontalMargin
                        )

                )


                Spacer(
                    modifier = Modifier.height(
                        Dimens.Home.CardToButton
                    )
                )


                AppButton(

                    text = "Gerar Nova Expressão",

                    backgroundColor = NoeBlue,

                    onClick = {

                        expressaoGerada =
                            gerarExpressaoNumerica()

                        resolucaoTexto = ""

                    }

                )

            }


        }


        // Barra superior - Movida para depois da Column para ficar no topo no Box
        AppTopBar(
            onBackClick = {
                if (resolucaoTexto.isNotEmpty()) {
                    // Estado 3 → Estado 2
                    resolucaoTexto = ""
                } else if (expressaoGerada.isNotEmpty()) {
                    // Estado 2 → Estado 1
                    expressaoGerada = ""
                }
            },
            onTermsClick = onTermsClick,
            onPrivacyClick = onPrivacyClick,
            showBackButton = expressaoGerada.isNotEmpty(),
            showMenu = true,
            fontScale = fontScale,
            onFontScaleChange = onFontScaleChange
        )


    }

}



@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {

    ExpressoesNumericasTheme {

        HomeScreen(

            onTermsClick = {},

            onPrivacyClick = {}

        )

    }

}
