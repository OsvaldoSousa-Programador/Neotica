package com.example.expressoesnumericas.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.expressoesnumericas.ui.components.AppTopBar
import com.example.expressoesnumericas.ui.legal.LegalTexts

@Composable
fun TermsScreen(
    onBackClick: () -> Unit
) {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        AppTopBar(
            onBackClick = onBackClick,
            showBackButton = true,
            showMenu = false
        )

        Column(
            modifier = Modifier
                .padding(24.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.Start
        ) {

            Text(
                text = "Termos de Uso",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            Text(
                text = LegalTexts.TermsOfUse,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}