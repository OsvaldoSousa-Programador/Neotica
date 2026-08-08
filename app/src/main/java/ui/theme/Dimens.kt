package com.example.expressoesnumericas.ui.theme

import androidx.compose.ui.unit.dp

object Dimens {

    /**
     * Espaçamentos padrão
     */
    object Spacing {
        val XS = 4.dp
        val S = 8.dp
        val M = 16.dp
        val L = 24.dp
        val XL = 32.dp
        val XXL = 40.dp
    }

    /**
     * Tamanhos dos componentes
     */
    object Size {

        val LogoWidth = 250.dp
        val LogoHeight = 80.dp

        val ButtonWidth = 305.dp
        val ButtonHeight = 68.dp

    }

    /**
     * Home
     */
    object Home {

        // Distância do topo da tela até a logo
        val LogoTop = 139.dp

        // Estado inicial
        val LogoToTitle = 84.dp
        val TitleToDescription = 3.dp
        val DescriptionToButton = 19.dp

        // Estado com expressão
        val LogoToCard = 54.dp
        val CardToButton = 26.dp
        val BetweenButtons = 10.dp

        // Padding horizontal padrão
        val HorizontalPadding = 24.dp

    }

    object TopBar {

        val Height = 56.dp

        val HorizontalPadding = 16.dp

        val TouchTarget = 48.dp

        val IconSize = 24.dp

        val IconSpacing = 8.dp

        val MenuOffsetX = (-12).dp

        val MenuOffsetY = 56.dp

        val MenuWidth = 190.dp

    }

    /**
     * Card
     */
    object Card {

        val Padding = 16.dp
        val HorizontalMargin = 40.dp

    }

    /**
     * Expressão
     */
    object Expression {

        val Padding = 24.dp

    }

}