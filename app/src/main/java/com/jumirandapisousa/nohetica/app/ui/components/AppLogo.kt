package com.jumirandapisousa.nohetica.app.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.jumirandapisousa.nohetica.app.R
import com.jumirandapisousa.nohetica.app.ui.theme.Dimens

@Composable
fun AppLogo(
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = R.drawable.logo_nohetica),
        contentDescription = "Logo Noetica",
        modifier = modifier
            .height(Dimens.Size.LogoHeight),
        contentScale = ContentScale.Fit
    )
}
