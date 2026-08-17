package com.jumirandapisousa.nohetica.app.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jumirandapisousa.nohetica.app.ui.components.AppTopBar
import com.jumirandapisousa.nohetica.app.ui.legal.LegalTexts
import com.jumirandapisousa.nohetica.app.ui.theme.BgTermos
import com.jumirandapisousa.nohetica.app.ui.theme.Black

@Composable
fun TermsScreen(
    onBackClick: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        AppTopBar(
            onBackClick = onBackClick,
            showBackButton = true,
            showMenu = false
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(
                    horizontal = 20.dp,
                    vertical = 16.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // TÍTULO PRINCIPAL
            Text(
                text = "TERMOS DE USO NOHETICA",
                style = MaterialTheme.typography.headlineSmall,
                color = Black
            )

            Spacer(
                modifier = Modifier.padding(top = 8.dp)
            )

            // DATA
            Text(
                text = "Última atualização: 16 de agosto de 2026",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(
                modifier = Modifier.padding(top = 20.dp)
            )

            // CAIXA DO CONTEÚDO
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = BgTermos
                ),
               shape = MaterialTheme.shapes.medium,
            ) {

                Text(
                    text = LegalTexts.TermsOfUse,
                    modifier = Modifier.padding(20.dp),
                    style = MaterialTheme.typography.bodyMedium,
                    color = Black,
                    lineHeight = MaterialTheme.typography.bodyMedium.lineHeight
                )
            }

            Spacer(
                modifier = Modifier.padding(bottom = 24.dp)
            )
        }
    }
}
