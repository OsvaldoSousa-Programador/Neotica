package com.jumirandapisousa.nohetica.app.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
        modifier = modifier
    ) {
        AppExpressionText(
            text = expression,
            modifier = Modifier.padding(Dimens.Card.Padding)
        )
    }

}
