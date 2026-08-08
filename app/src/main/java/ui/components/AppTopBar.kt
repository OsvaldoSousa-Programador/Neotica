package com.example.expressoesnumericas.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.expressoesnumericas.R
import com.example.expressoesnumericas.ui.theme.Dimens

@Composable
fun AppTopBar(
    onBackClick: () -> Unit = {},
    onTermsClick: () -> Unit = {},
    onPrivacyClick: () -> Unit = {},
    showBackButton: Boolean = true,
    showMenu: Boolean = true
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(Dimens.TopBar.Height)
            .padding(horizontal = Dimens.TopBar.HorizontalPadding)
    ) {

        Row(
            modifier = Modifier.align(Alignment.CenterEnd),
            horizontalArrangement = Arrangement.spacedBy(
                Dimens.TopBar.IconSpacing
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {

            if (showBackButton) {

                AppIconButton(
                    iconRes = R.drawable.arrow_back,
                    contentDescription = "Voltar",
                    onClick = onBackClick
                )

            }

            if (showMenu) {

                AppIconButton(
                    iconRes = R.drawable.menu,
                    contentDescription = "Menu",
                    onClick = {
                        // Menu será implementado na próxima etapa.
                    }
                )

            }

        }

    }

}