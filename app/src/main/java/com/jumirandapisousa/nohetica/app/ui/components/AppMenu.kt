package com.jumirandapisousa.nohetica.app.ui.components

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ripple
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jumirandapisousa.nohetica.app.ui.theme.MenuBackground
import com.jumirandapisousa.nohetica.app.ui.theme.MenuDivider
import com.jumirandapisousa.nohetica.app.ui.theme.MenuText
import com.jumirandapisousa.nohetica.app.ui.theme.NoeBlue
import com.jumirandapisousa.nohetica.app.ui.theme.White

@Composable
fun AppMenu(
    onTermsClick: () -> Unit,
    onPrivacyClick: () -> Unit,
    fontScale: Float = 1f,
    onFontScaleChange: (Float) -> Unit = {}
) {

    Card(
        modifier = Modifier.width(240.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = MenuBackground
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            
            // SEÇÃO DE ACESSIBILIDADE
            Text(
                text = "ACESSIBILIDADE",
                style = MaterialTheme.typography.labelSmall,
                color = MenuText.copy(alpha = 0.5f),
                modifier = Modifier.padding(start = 12.dp, top = 8.dp, bottom = 4.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Tamanho da Fonte",
                    style = MaterialTheme.typography.bodySmall,
                    color = MenuText
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    // Botão Diminuir
                    FontSizeControl(
                        text = "A-",
                        enabled = fontScale > 0.8f,
                        onClick = { onFontScaleChange(fontScale - 0.2f) }
                    )

                    // Botão Aumentar
                    FontSizeControl(
                        text = "A+",
                        enabled = fontScale < 2.0f,
                        onClick = { onFontScaleChange(fontScale + 0.2f) }
                    )
                }
            }

            HorizontalDivider(
                color = MenuDivider,
                modifier = Modifier.padding(vertical = 4.dp)
            )

            AppMenuItem(
                text = "Termos de Uso",
                onClick = onTermsClick
            )

            HorizontalDivider(
                color = MenuDivider
            )

            AppMenuItem(
                text = "Política de Privacidade",
                onClick = onPrivacyClick
            )
        }

    }

}

@Composable
private fun FontSizeControl(
    text: String,
    enabled: Boolean,
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    
    var visualPressed by remember { mutableStateOf(false) }
    LaunchedEffect(isPressed) {
        if (isPressed) visualPressed = true
        else {
            kotlinx.coroutines.delay(150)
            visualPressed = false
        }
    }

    val scale by animateFloatAsState(
        targetValue = if (visualPressed) 0.9f else 1f,
        animationSpec = spring(stiffness = Spring.StiffnessHigh),
        label = "FontSizeControlScale"
    )

    Box(
        modifier = Modifier
            .size(32.dp)
            .scale(scale)
            .clip(CircleShape)
            .background(if (enabled) NoeBlue else MenuDivider)
            .clickable(enabled = enabled, interactionSource = interactionSource, indication = ripple()) {
                onClick()
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = White,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun AppMenuItem(
    text: String,
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    
    // Estado visual para garantir que o clique seja perceptível
    var visualPressed by remember { mutableStateOf(false) }

    LaunchedEffect(isPressed) {
        if (isPressed) {
            visualPressed = true
        } else {
            kotlinx.coroutines.delay(100)
            visualPressed = false
        }
    }

    val scale by animateFloatAsState(
        targetValue = if (visualPressed) 0.96f else 1f,
        animationSpec = spring(stiffness = Spring.StiffnessHigh),
        label = "MenuItemScale"
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 48.dp)
            .scale(scale)
            .clickable(
                interactionSource = interactionSource,
                indication = ripple(),
                onClick = onClick
            )
            .padding(horizontal = 12.dp, vertical = 12.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            color = MenuText
        )
    }
}
