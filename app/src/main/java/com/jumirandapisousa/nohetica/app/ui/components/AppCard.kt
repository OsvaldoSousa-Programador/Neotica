package com.jumirandapisousa.nohetica.app.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jumirandapisousa.nohetica.app.ui.theme.AppShapes
import com.jumirandapisousa.nohetica.app.ui.theme.Dimens
import com.jumirandapisousa.nohetica.app.ui.theme.NeoBlueCard


@Composable
fun AppCard(
    expression: String,
    modifier: Modifier = Modifier
) {
    Card(
        shape = AppShapes.card,
        colors = CardDefaults.cardColors(
            containerColor = NeoBlueCard
        ),
        modifier = modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            // Espaço reduzido para subir a expressão em uma linha
            Spacer(modifier = Modifier.height(20.dp))
            
            AppExpressionText(
                text = expression,
                modifier = Modifier.padding(Dimens.Card.Padding)
            )
        }
    }
}
