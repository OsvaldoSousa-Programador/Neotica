package com.example.expressoesnumericas.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.expressoesnumericas.R
import com.example.expressoesnumericas.ui.theme.Dimens

@Composable
fun AppLogo(
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = R.drawable.logo_noetica),
        contentDescription = "Logo Noetica",
        modifier = modifier
            .padding(top = Dimens.Home.LogoTop)
            .height(Dimens.Size.LogoHeight),
        contentScale = ContentScale.Fit
    )
}