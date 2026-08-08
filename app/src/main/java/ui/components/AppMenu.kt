package com.example.expressoesnumericas.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.expressoesnumericas.ui.theme.AppShapes
import com.example.expressoesnumericas.ui.theme.White

@Composable
fun AppMenu(
    onTermsClick: () -> Unit,
    onPrivacyClick: () -> Unit
) {

    Card(
        modifier = Modifier.width(190.dp),
        shape = AppShapes.card,
        colors = CardDefaults.cardColors(
            containerColor = White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    ) {

        Column {

            Text(
                text = "Termos de Uso",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onTermsClick() }
                    .padding(16.dp)
            )

            HorizontalDivider()

            Text(
                text = "Política de Privacidade",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onPrivacyClick() }
                    .padding(16.dp)
            )

        }

    }

}