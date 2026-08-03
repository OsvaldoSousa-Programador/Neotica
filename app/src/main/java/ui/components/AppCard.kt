package com.example.expressoesnumericas.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.expressoesnumericas.ui.theme.AppShapes
import com.example.expressoesnumericas.ui.theme.Dimens

@Composable
fun AppCard(
    expression: String,
    modifier: Modifier = Modifier
) {

    Card(
        shape = AppShapes.card,
        modifier = modifier
    ) {

        AppExpressionText(
            text = expression,
            modifier = Modifier.padding(Dimens.Expression.Padding)
        )

    }

}