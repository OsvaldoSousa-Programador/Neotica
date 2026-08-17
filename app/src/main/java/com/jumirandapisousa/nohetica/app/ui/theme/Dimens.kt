package com.jumirandapisousa.nohetica.app.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass

data class AppDimens(
    val spacing: Spacing = Spacing(),
    val size: Size = Size(),
    val home: Home = Home(),
    val topBar: TopBar = TopBar(),
    val card: Card = Card(),
    val expression: Expression = Expression()
) {
    data class Spacing(
        val XS: Dp = 4.dp,
        val S: Dp = 8.dp,
        val M: Dp = 16.dp,
        val L: Dp = 24.dp,
        val XL: Dp = 32.dp,
        val XXL: Dp = 40.dp
    )

    data class Size(
        val LogoWidth: Dp = 250.dp,
        val LogoHeight: Dp = 80.dp,
        val ButtonWidth: Dp = 305.dp,
        val ButtonHeight: Dp = 68.dp
    )

    data class Home(
        val LogoTop: Dp = 139.dp,
        val LogoToTitle: Dp = 84.dp,
        val TitleToDescription: Dp = 3.dp,
        val DescriptionToButton: Dp = 19.dp,
        val LogoToCard: Dp = 54.dp,
        val CardToButton: Dp = 26.dp,
        val BetweenButtons: Dp = 10.dp,
        val HorizontalPadding: Dp = 24.dp
    )

    data class TopBar(
        val Height: Dp = 56.dp,
        val HorizontalPadding: Dp = 16.dp,
        val TouchTarget: Dp = 48.dp,
        val IconSize: Dp = 24.dp,
        val IconSpacing: Dp = 8.dp,
        val MenuOffsetX: Dp = (-12).dp,
        val MenuOffsetY: Dp = 56.dp,
        val MenuWidth: Dp = 190.dp
    )

    data class Card(
        val Padding: Dp = 16.dp,
        val HorizontalMargin: Dp = 40.dp
    )

    data class Expression(
        val Padding: Dp = 24.dp
    )
}

/**
 * Função para aplicar escala de fonte apenas em dimensões que precisam crescer (como botões)
 */
fun AppDimens.withFontScale(fontScale: Float): AppDimens {
    return this.copy(
        size = this.size.copy(
            ButtonWidth = this.size.ButtonWidth * fontScale,
            ButtonHeight = this.size.ButtonHeight * fontScale
        )
    )
}

val CompactDimens = AppDimens(
    home = AppDimens.Home(
        LogoTop = 130.dp
    )
)

val MediumDimens = AppDimens()

val ExpandedDimens = AppDimens(
    size = AppDimens.Size(
        LogoWidth = 400.dp,
        LogoHeight = 120.dp,
        ButtonWidth = 450.dp
    )
)

val LocalDimens = staticCompositionLocalOf { CompactDimens }

@Composable
fun ProvideDimens(
    windowWidthSizeClass: WindowWidthSizeClass,
    fontScale: Float = 1f,
    content: @Composable () -> Unit
) {
    val baseDimens = when (windowWidthSizeClass) {
        WindowWidthSizeClass.Compact -> CompactDimens
        WindowWidthSizeClass.Medium -> MediumDimens
        WindowWidthSizeClass.Expanded -> ExpandedDimens
        else -> CompactDimens
    }
    
    val dimens = baseDimens.withFontScale(fontScale)

    CompositionLocalProvider(LocalDimens provides dimens) {
        content()
    }
}

object Dimens {
    val Spacing @Composable @ReadOnlyComposable get() = LocalDimens.current.spacing
    val Size @Composable @ReadOnlyComposable get() = LocalDimens.current.size
    val Home @Composable @ReadOnlyComposable get() = LocalDimens.current.home
    val TopBar @Composable @ReadOnlyComposable get() = LocalDimens.current.topBar
    val Card @Composable @ReadOnlyComposable get() = LocalDimens.current.card
    val Expression @Composable @ReadOnlyComposable get() = LocalDimens.current.expression
}
