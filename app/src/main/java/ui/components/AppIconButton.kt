package com.example.expressoesnumericas.ui.components

import androidx.compose.foundation.Image
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.expressoesnumericas.ui.theme.Dimens
import androidx.compose.foundation.layout.size

@Composable
fun AppIconButton(
    iconRes: Int,
    contentDescription: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    touchTarget: Dp = Dimens.TopBar.TouchTarget,
    iconSize: Dp = Dimens.TopBar.IconSize
) {

    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {

        Image(
            painter = painterResource(id = iconRes),
            contentDescription = contentDescription,
            modifier = Modifier.size(iconSize)
        )

    }

}