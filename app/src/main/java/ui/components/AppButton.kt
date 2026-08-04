package com.example.expressoesnumericas.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.expressoesnumericas.ui.theme.AppShapes
import com.example.expressoesnumericas.ui.theme.Dimens
import com.example.expressoesnumericas.ui.theme.NoeBlue
import com.example.expressoesnumericas.ui.theme.White

@Composable
fun AppButton(
    text: String,
    modifier: Modifier = Modifier,
    backgroundColor: Color = NoeBlue,
    onClick: () -> Unit
) {

    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = White
        ),
        shape = AppShapes.button,
        modifier = modifier
            .width(Dimens.Size.ButtonWidth)
            .height(Dimens.Size.ButtonHeight)
    ) {

        AppButtonText(text = text)

    }

}