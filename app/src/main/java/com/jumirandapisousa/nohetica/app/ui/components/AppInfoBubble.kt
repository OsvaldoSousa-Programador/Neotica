package com.jumirandapisousa.nohetica.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jumirandapisousa.nohetica.app.ui.theme.NoeActionBackground
import com.jumirandapisousa.nohetica.app.ui.theme.NoeActionContent
import com.jumirandapisousa.nohetica.app.ui.theme.NoeOkButton
import com.jumirandapisousa.nohetica.app.ui.theme.NoeShadow
import com.jumirandapisousa.nohetica.app.ui.theme.White

@Composable
fun AppInfoBubble(
    text: String,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
) {
    // Sharp corner no TopEnd para encaixar no ícone
    val shape = RoundedCornerShape(topStart = 24.dp, topEnd = 4.dp, bottomStart = 24.dp, bottomEnd = 24.dp)
    
    Box(
        modifier = modifier
            .widthIn(max = 280.dp) 
            .shadow(
                elevation = 16.dp, // Sombra um pouco mais forte para destacar o balão
                shape = shape,
                ambientColor = NoeShadow,
                spotColor = NoeShadow
            )
            .clip(shape)
            .background(NoeActionBackground)
            .padding(16.dp)
    ) {
        Column {
            Text(
                text = text,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = NoeActionContent,
                    fontSize = 16.sp,
                    lineHeight = 22.sp,
                    fontWeight = FontWeight.Medium
                )
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Box(
                modifier = Modifier
                    .align(Alignment.End)
                    .clip(RoundedCornerShape(12.dp))
                    .background(NoeOkButton)
                    .clickable { onDismiss() }
                    .padding(horizontal = 20.dp, vertical = 10.dp)
            ) {
                Text(
                    text = "Entendi!",
                    color = NoeActionContent,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
