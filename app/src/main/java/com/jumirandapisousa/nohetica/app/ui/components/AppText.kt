package com.jumirandapisousa.nohetica.app.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle

@Composable
fun AppTitleText(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        modifier = modifier,
        style = MaterialTheme.typography.titleMedium,
        textAlign = TextAlign.Center
    )
}

@Composable
fun AppBodyText(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        modifier = modifier,
        style = MaterialTheme.typography.bodyMedium,
        textAlign = TextAlign.Center
    )
}

@Composable
fun AppButtonText(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        modifier = modifier,
        style = MaterialTheme.typography.labelLarge
    )
}

@Composable
fun AppExpressionText(
    text: String,
    modifier: Modifier = Modifier,
    softWrap: Boolean = true
) {

    val linhas = text.split("\n")

    val textoFormatado = buildAnnotatedString {

        linhas.forEachIndexed { indice, linha ->

            if (linha.startsWith("R=")) {

                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append(linha)
                }

            } else {

                append(linha)
            }

            if (indice < linhas.lastIndex) {
                append("\n")
            }
        }
    }

    Text(
        text = textoFormatado,
        modifier = modifier,
        style = MaterialTheme.typography.headlineMedium,
        textAlign = TextAlign.Start,
        softWrap = true
    )
}
