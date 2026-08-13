package com.example.expressoesnumericas.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.expressoesnumericas.ui.theme.MenuBackground
import com.example.expressoesnumericas.ui.theme.MenuDivider
import com.example.expressoesnumericas.ui.theme.MenuText

@Composable
fun AppMenu(
    onTermsClick: () -> Unit,
    onPrivacyClick: () -> Unit
) {

    Card(
        modifier = Modifier.width(210.dp),
        shape = RoundedCornerShape(5.dp),
        colors = CardDefaults.cardColors(
            containerColor = MenuBackground
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {

            Text(
                text = "Termos de Uso",
                style = MaterialTheme.typography.bodyMedium,
                color = MenuText,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .clickable {
                        onTermsClick()
                    }
                    .padding(horizontal = 12.dp),
            )

            HorizontalDivider(
                color = MenuDivider
            )

            Text(
                text = "Política de Privacidade",
                style = MaterialTheme.typography.bodyMedium,
                color = MenuText,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .clickable {
                        onPrivacyClick()
                    }
                    .padding(horizontal = 12.dp)
            )
        }

    }

}