package com.jumirandapisousa.nohetica.app.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.text.AnnotatedString
import android.content.Intent
import android.widget.Toast
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Calculate
import androidx.compose.material.icons.rounded.ContentCopy
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.outlined.EmojiEvents
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import com.jumirandapisousa.nohetica.app.ui.components.AppActionButton
import com.jumirandapisousa.nohetica.app.ui.components.AppDashboardCard
import com.jumirandapisousa.nohetica.app.ui.components.AppInfoBubble
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
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
import com.jumirandapisousa.nohetica.app.ui.theme.NoeActionBackground
import com.jumirandapisousa.nohetica.app.ui.theme.NoeActionContent
import com.jumirandapisousa.nohetica.app.ui.theme.GradientTop
import com.jumirandapisousa.nohetica.app.ui.theme.GradientBottom
import com.jumirandapisousa.nohetica.app.ui.theme.ButtonBlueStart
import com.jumirandapisousa.nohetica.app.ui.theme.ButtonBlueEnd
import com.jumirandapisousa.nohetica.app.ui.theme.ButtonOrangeStart
import com.jumirandapisousa.nohetica.app.ui.theme.ButtonOrangeEnd
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

    var helpText by remember { mutableStateOf<String?>(null) }

    val verticalScrollState = rememberScrollState()
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp

    val blueBrush = Brush.horizontalGradient(listOf(ButtonBlueStart, ButtonBlueEnd))
    val orangeBrush = Brush.horizontalGradient(listOf(ButtonOrangeStart, ButtonOrangeEnd))

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(GradientTop, GradientBottom)
                )
            )
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
                .padding(
                    top = Dimens.Home.LogoTop,
                    bottom = Dimens.Home.LogoTop
                ),

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

                    backgroundBrush = blueBrush,

                    onClick = {

                        expressaoGerada =
                            gerarExpressaoNumerica()

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

                Box(modifier = Modifier.padding(horizontal = 20.dp)) {
                    AppDashboardCard(
                        title = "Expressão Atual",
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp)) // Recorta antes do blur
                            .blur(if (helpText != null) 12.dp else 0.dp)
                    ) {
                        AppCard(
                            expression = expressaoGerada,
                            modifier = Modifier.fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        // TRIO DE BOTÕES (COPIAR, DESAFIAR, COMPARTILHAR) - ESTADO 2
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            AppActionButton(
                                text = "Copiar",
                                icon = Icons.Rounded.ContentCopy,
                                onClick = {
                                    clipboardManager.setText(AnnotatedString(expressaoGerada))
                                    Toast.makeText(context, "Pergunta copiada!", Toast.LENGTH_SHORT).show()
                                }
                            )

                            Spacer(modifier = Modifier.width(4.dp))

                            AppActionButton(
                                text = "Desafiar",
                                icon = Icons.Outlined.EmojiEvents,
                                onClick = {
                                    val challengeMessage = "Você consegue resolver essa?\n\n$expressaoGerada\n\nBaixe o app: https://play.google.com/store/apps/details?id=com.jumirandapisousa.nohetica.app"
                                    val sendIntent: Intent = Intent().apply {
                                        action = Intent.ACTION_SEND
                                        putExtra(Intent.EXTRA_TEXT, challengeMessage)
                                        type = "text/plain"
                                    }
                                    val shareIntent = Intent.createChooser(sendIntent, null)
                                    context.startActivity(shareIntent)
                                }
                            )

                            Spacer(modifier = Modifier.width(4.dp))

                            AppActionButton(
                                text = "",
                                icon = Icons.Outlined.Share,
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
                    }

                    // Botão Informativo "i" - Posicionado dentro do card com mais respiro
                    Box(
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(top = 44.dp, end = 20.dp) // Movido para a direita (de 32 para 20)
                            .size(32.dp)
                            .clip(CircleShape)
                            .background(NoeActionBackground)
                            .clickable { 
                                helpText = "Você pode resolver com calma no seu caderno e só então tocar em Resolver Expressão"
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "i",
                            color = NoeActionContent,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    // Balão de Informação - "Colado" e mais alto para não cobrir o botão de baixo
                    helpText?.let { text ->
                        AppInfoBubble(
                            text = text,
                            onDismiss = { helpText = null },
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .offset(x = (-47).dp, y = 62.dp) // Subi de 71 para 62dp
                        )
                    }
                }

                Spacer(
                    modifier = Modifier.height(
                        Dimens.Home.CardToButton
                    )
                )

                AppButton(

                    text = "Resolver Expressão",

                    backgroundBrush = orangeBrush,

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

                    backgroundBrush = blueBrush,

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

                Box(modifier = Modifier.padding(horizontal = 20.dp)) {
                    AppDashboardCard(
                        title = "Resolução",
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .blur(if (helpText != null) 12.dp else 0.dp)
                    ) {
                        AppCard(
                            expression = resolucaoTexto,
                            modifier = Modifier.fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        // TRIO DE BOTÕES (COPIAR, DESAFIAR, COMPARTILHAR) - ESTADO 3
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            AppActionButton(
                                text = "Copiar",
                                icon = Icons.Rounded.ContentCopy,
                                onClick = {
                                    clipboardManager.setText(AnnotatedString(resolucaoTexto))
                                    Toast.makeText(context, "Resolução copiada!", Toast.LENGTH_SHORT).show()
                                    analytics.logEvent("result_copied", null)
                                }
                            )

                            Spacer(modifier = Modifier.width(4.dp))

                            AppActionButton(
                                text = "Desafiar",
                                icon = Icons.Outlined.EmojiEvents,
                                onClick = {
                                    val challengeMessage = "Você consegue resolver essa?\n\n$expressaoGerada\n\nBaixe o app: https://play.google.com/store/apps/details?id=com.jumirandapisousa.nohetica.app"
                                    val sendIntent: Intent = Intent().apply {
                                        action = Intent.ACTION_SEND
                                        putExtra(Intent.EXTRA_TEXT, challengeMessage)
                                        type = "text/plain"
                                    }
                                    val shareIntent = Intent.createChooser(sendIntent, null)
                                    context.startActivity(shareIntent)
                                }
                            )

                            Spacer(modifier = Modifier.width(4.dp))

                            AppActionButton(
                                text = "",
                                icon = Icons.Outlined.Share,
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
                    }

                    // Botão Informativo "i" - Nítido sobre a resolução
                    Box(
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(top = 44.dp, end = 20.dp)
                            .size(32.dp)
                            .clip(CircleShape)
                            .background(NoeActionBackground)
                            .clickable { 
                                helpText = "Para resolver Expressões numéricas, primeiro você resolve as contas dentro de parênteses (), na linha seguinte as contas de colchetes [] e por ultimos as das chaves {}."
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "i",
                            color = NoeActionContent,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    // Balão de Informação - Estado 3
                    helpText?.let { text ->
                        AppInfoBubble(
                            text = text,
                            onDismiss = { helpText = null },
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .offset(x = (-47).dp, y = 62.dp)
                        )
                    }
                }

                Spacer(
                    modifier = Modifier.height(
                        Dimens.Home.CardToButton
                    )
                )


                AppButton(

                    text = "Gerar Nova Expressão",

                    backgroundBrush = blueBrush,

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
