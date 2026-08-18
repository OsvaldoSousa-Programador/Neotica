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
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.text.AnnotatedString
import android.content.Intent
import android.widget.Toast
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ContentCopy
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material.icons.rounded.EmojiEvents
import androidx.compose.foundation.layout.Row
import com.jumirandapisousa.nohetica.app.ui.components.AppActionButton
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import android.content.Context
import androidx.compose.ui.platform.LocalContext
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.logEvent

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
    val context = LocalContext.current
    val clipboardManager = LocalClipboardManager.current

    val analytics = remember {
        FirebaseAnalytics.getInstance(context)
    }

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

                        android.util.Log.d(
                            "NOHETICA_ANALYTICS",
                            "expression_generated chamado"
                        )

                        analytics.logEvent("expression_generated", null)

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

                // TRIO DE BOTÕES (COPIAR, DESAFIAR, COMPARTILHAR) - ESTADO 2
                Row(
                    modifier = Modifier
                        .width(Dimens.Size.ButtonWidth * 0.92f), // 92% da largura do botão principal
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AppActionButton(
                        text = "Copiar",
                        icon = Icons.Rounded.ContentCopy,
                        onClick = {
                            clipboardManager.setText(AnnotatedString(expressaoGerada))
                            Toast.makeText(context, "Pergunta copiada!", Toast.LENGTH_SHORT).show()
                        },
                        modifier = Modifier.weight(1f)
                    )

                    AppActionButton(
                        text = "Desafiar",
                        icon = Icons.Rounded.EmojiEvents,
                        onClick = {
                            val challengeMessage = "Você consegue resolver essa?\n\n$expressaoGerada\n\nBaixe o app: https://play.google.com/store/apps/details?id=com.jumirandapisousa.nohetica.app"
                            val sendIntent: Intent = Intent().apply {
                                action = Intent.ACTION_SEND
                                putExtra(Intent.EXTRA_TEXT, challengeMessage)
                                type = "text/plain"
                            }
                            val shareIntent = Intent.createChooser(sendIntent, null)
                            context.startActivity(shareIntent)
                        },
                        modifier = Modifier.weight(1f)
                    )

                    AppActionButton(
                        text = "",
                        icon = Icons.Rounded.Share,
                        onClick = {
                            val shareMessage = "Duvido você resolver essa expressão! 🧠\n\n$expressaoGerada\n\nBaixe o app: https://play.google.com/store/apps/details?id=com.jumirandapisousa.nohetica.app"
                            val sendIntent: Intent = Intent().apply {
                                action = Intent.ACTION_SEND
                                putExtra(Intent.EXTRA_TEXT, shareMessage)
                                type = "text/plain"
                            }
                            val shareIntent = Intent.createChooser(sendIntent, null)
                            context.startActivity(shareIntent)
                        }
                    )
                }

                Spacer(
                    modifier = Modifier.height(
                        Dimens.Home.BetweenButtons
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

                        analytics.logEvent("expression_solved", null)
                        analytics.logEvent("solution_viewed", null)

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

                        analytics.logEvent("expression_generated", null)

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

                // TRIO DE BOTÕES (COPIAR, DESAFIAR, COMPARTILHAR) - ESTADO 3
                Row(
                    modifier = Modifier
                        .width(Dimens.Size.ButtonWidth * 0.92f), // 92% da largura do botão principal
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AppActionButton(
                        text = "Copiar",
                        icon = Icons.Rounded.ContentCopy,
                        onClick = {
                            clipboardManager.setText(AnnotatedString(resolucaoTexto))
                            Toast.makeText(context, "Resolução copiada!", Toast.LENGTH_SHORT).show()
                            analytics.logEvent("result_copied", null)
                        },
                        modifier = Modifier.weight(1f)
                    )

                    AppActionButton(
                        text = "Desafiar",
                        icon = Icons.Rounded.EmojiEvents,
                        onClick = {
                            val challengeMessage = "Você consegue resolver essa?\n\n$expressaoGerada\n\nBaixe o app: https://play.google.com/store/apps/details?id=com.jumirandapisousa.nohetica.app"
                            val sendIntent: Intent = Intent().apply {
                                action = Intent.ACTION_SEND
                                putExtra(Intent.EXTRA_TEXT, challengeMessage)
                                type = "text/plain"
                            }
                            val shareIntent = Intent.createChooser(sendIntent, null)
                            context.startActivity(shareIntent)
                        },
                        modifier = Modifier.weight(1f)
                    )

                    AppActionButton(
                        text = "",
                        icon = Icons.Rounded.Share,
                        onClick = {
                            val shareMessage = "Resolvi essa expressão! Estuda aqui abaixo como foi.\n\n$resolucaoTexto\n\nBaixe o app: https://play.google.com/store/apps/details?id=com.jumirandapisousa.nohetica.app"
                            val sendIntent: Intent = Intent().apply {
                                action = Intent.ACTION_SEND
                                putExtra(Intent.EXTRA_TEXT, shareMessage)
                                type = "text/plain"
                            }
                            val shareIntent = Intent.createChooser(sendIntent, null)
                            context.startActivity(shareIntent)
                            analytics.logEvent("result_shared", null)
                        }
                    )
                }


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

                        analytics.logEvent("expression_generated", null)

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
            onFontScaleChange = { newScale ->
                onFontScaleChange(newScale)
                analytics.logEvent("font_scale_changed") {
                    param("scale_value", newScale.toDouble())
                }
            }
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
