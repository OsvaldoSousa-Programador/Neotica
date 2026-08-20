package com.jumirandapisousa.nohetica.app.ui.components

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.jumirandapisousa.nohetica.app.ui.theme.AppShapes
import com.jumirandapisousa.nohetica.app.ui.theme.Dimens
import com.jumirandapisousa.nohetica.app.ui.theme.NoeBlue
import com.jumirandapisousa.nohetica.app.ui.theme.White
import kotlinx.coroutines.delay

@Composable
fun AppButton(
    text: String,
    modifier: Modifier = Modifier,
    backgroundColor: Color = NoeBlue,
    backgroundBrush: Brush? = null,
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    
    // Estado visual para garantir que o clique seja perceptível mesmo se for rápido
    var visualPressed by remember { mutableStateOf(false) }

    LaunchedEffect(isPressed) {
        if (isPressed) {
            visualPressed = true
        } else {
            // Mantém o estado visual por pelo menos 150ms para o olho humano captar
            delay(150)
            visualPressed = false
        }
    }

    val scale by animateFloatAsState(
        targetValue = if (visualPressed) 0.90f else 1f,
        animationSpec = spring(stiffness = Spring.StiffnessHigh),
        label = "ButtonScale"
    )

    val buttonModifier = modifier
        .width(Dimens.Size.ButtonWidth)
        .height(Dimens.Size.ButtonHeight)
        .scale(scale)

    Button(
        onClick = onClick,
        interactionSource = interactionSource,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (backgroundBrush == null) backgroundColor else Color.Transparent,
            contentColor = White
        ),
        shape = AppShapes.button, // Já está configurado como 16dp no AppShapes
        modifier = if (backgroundBrush != null) {
            buttonModifier.background(backgroundBrush, AppShapes.button)
        } else {
            buttonModifier
        },
        contentPadding = androidx.compose.foundation.layout.PaddingValues(0.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            AppButtonText(text = text)
        }
    }

}
