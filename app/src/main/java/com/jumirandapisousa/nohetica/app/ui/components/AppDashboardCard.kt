package com.jumirandapisousa.nohetica.app.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jumirandapisousa.nohetica.app.ui.theme.NoeBlue
import com.jumirandapisousa.nohetica.app.ui.theme.NoeShadow
import com.jumirandapisousa.nohetica.app.ui.theme.White

@Composable
fun AppDashboardCard(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    val shape = RoundedCornerShape(8.dp)
    
    Card(
        modifier = modifier
            .fillMaxWidth()
            .shadow(
                elevation = 12.dp,
                shape = shape,
                ambientColor = NoeShadow,
                spotColor = NoeShadow
            )
            // Esta camada garante que o efeito de blur seja recortado nos cantos de 8dp
            .graphicsLayer {
                this.clip = true
                this.shape = shape
            },
        shape = shape,
        colors = CardDefaults.cardColors(
            containerColor = White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Text(
                text = title.uppercase(),
                style = MaterialTheme.typography.labelMedium.copy(
                    color = NoeBlue,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    letterSpacing = 1.sp
                ),
                modifier = Modifier.padding(bottom = 8.dp)
            )
            
            content()
        }
    }
}
