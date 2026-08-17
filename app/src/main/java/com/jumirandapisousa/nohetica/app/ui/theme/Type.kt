package com.jumirandapisousa.nohetica.app.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.jumirandapisousa.nohetica.app.R

// Fonte padrão do aplicativo
val Inter = FontFamily(
    Font(R.font.inter_18pt_regular, FontWeight.Normal),
    Font(R.font.inter_18pt_medium, FontWeight.Medium),
    Font(R.font.inter_18pt_semibold, FontWeight.SemiBold)
)

/**
 * Retorna a tipografia do Noetica ajustada por uma escala de acessibilidade.
 */
fun getAppTypography(fontScale: Float): Typography {
    return Typography(
        // Expressão matemática exibida no Card
        headlineMedium = TextStyle(
            fontFamily = Inter,
            fontWeight = FontWeight.Medium,
            fontSize = (18 * fontScale).sp,
            letterSpacing = 0.sp
        ),

        // Título principal
        titleMedium = TextStyle(
            fontFamily = Inter,
            fontWeight = FontWeight.SemiBold,
            fontSize = (18 * fontScale).sp,
            letterSpacing = 0.sp
        ),

        // Texto de apoio
        bodyMedium = TextStyle(
            fontFamily = Inter,
            fontWeight = FontWeight.Medium,
            fontSize = (16 * fontScale).sp,
            letterSpacing = 0.sp
        ),

        // Texto dos botões
        labelLarge = TextStyle(
            fontFamily = Inter,
            fontWeight = FontWeight.Medium,
            fontSize = (22 * fontScale).sp,
            letterSpacing = 0.sp
        )
    )
}

// Mantendo para retrocompatibilidade se necessário
val AppTypography = getAppTypography(1f)
