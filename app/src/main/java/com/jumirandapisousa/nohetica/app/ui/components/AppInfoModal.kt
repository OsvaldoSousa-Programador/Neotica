package com.jumirandapisousa.nohetica.app.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jumirandapisousa.nohetica.app.R
import com.jumirandapisousa.nohetica.app.ui.theme.NoeActionContent
import com.jumirandapisousa.nohetica.app.ui.theme.NoeOkButton
import com.jumirandapisousa.nohetica.app.ui.theme.NoeShadow
import com.jumirandapisousa.nohetica.app.ui.theme.White

@Composable
fun AppInfoModal(
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
) {
    val shape = RoundedCornerShape(8.dp)
    
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = modifier
                .size(width = 253.dp, height = 257.dp)
                .shadow(
                    elevation = 16.dp,
                    shape = shape,
                    ambientColor = NoeShadow,
                    spotColor = NoeShadow
                ),
            shape = shape,
            colors = CardDefaults.cardColors(containerColor = White),
            elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 13.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                // N subiu: Reduzido de 25dp para 10dp
                Spacer(modifier = Modifier.height(2.dp))
                
                // Ícone da Nohetica (120dp)
                Image(
                    painter = painterResource(id = R.drawable.n_icon_ad),
                    contentDescription = "Ícone Nohetica",
                    modifier = Modifier.height(120.dp),
                    contentScale = ContentScale.Fit
                )
                
                // Espaço de 12dp entre o N e o texto
                Spacer(modifier = Modifier.height(0.dp))
                
                // Texto Informativo
                Text(
                    text = "Você pode resolver com calma no seu caderno, e só então, tocar em Resolver Expressão",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = NoeActionContent,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium,
                        lineHeight = 18.sp
                    ),
                    textAlign = TextAlign.Center
                )
                
                // Espaço de 12dp entre o texto e o botão
                Spacer(modifier = Modifier.height(20.dp))
                
                // Botão Entendi!
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .background(NoeOkButton)
                        .clickable { onDismiss() }
                        .padding(horizontal = 24.dp, vertical = 8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Entendi!",
                        color = NoeActionContent,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
                
                // Espaço final: 9dp
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}
