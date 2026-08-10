package com.example.expressoesnumericas.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.expressoesnumericas.R
import com.example.expressoesnumericas.ui.theme.Dimens
import androidx.compose.ui.zIndex
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties

@Composable
fun AppTopBar(
    onBackClick: () -> Unit = {},
    onTermsClick: () -> Unit = {},
    onPrivacyClick: () -> Unit = {},
    showBackButton: Boolean = true,
    showMenu: Boolean = true
) {

    var menuExpanded by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(Dimens.TopBar.Height)
            .padding(horizontal = Dimens.TopBar.HorizontalPadding)
    ) {

        // ÍCONES NO CANTO SUPERIOR DIREITO
        Row(
            modifier = Modifier.align(Alignment.TopEnd),
            horizontalArrangement = Arrangement.spacedBy(
                Dimens.TopBar.IconSpacing
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // SETA
            if (showBackButton) {

                AppIconButton(
                    iconRes = R.drawable.arrow_back,
                    contentDescription = "Voltar",
                    onClick = onBackClick
                )
            }

            // TRÊS PONTINHOS
            if (showMenu) {

                AppIconButton(
                    iconRes = R.drawable.menu,
                    contentDescription = "Menu",
                    onClick = {
                        menuExpanded = !menuExpanded
                    }
                )
            }
        }

        // OPÇÕES DO MENU
        if (menuExpanded) {

            Popup(
                alignment = Alignment.TopEnd,
                offset = androidx.compose.ui.unit.IntOffset(
                    x = -Dimens.TopBar.HorizontalPadding.value.toInt(),
                    y = Dimens.TopBar.MenuOffsetY.value.toInt()
                ),
                onDismissRequest = {
                    menuExpanded = false
                },
                properties = PopupProperties(
                    focusable = true
                )
            ) {

                AppMenu(
                    onTermsClick = {
                        menuExpanded = false
                        onTermsClick()
                    },
                    onPrivacyClick = {
                        menuExpanded = false
                        onPrivacyClick()
                    }
                )
            }
        }
    }
}