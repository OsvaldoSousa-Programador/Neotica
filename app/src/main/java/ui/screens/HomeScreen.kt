package com.example.expressoesnumericas.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ui.theme.ExpressoesNumericasTheme

@Composable
fun HomeScreen() {

    var expressaoGerada by remember {
        mutableStateOf("")
    }


    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Text(
            text = "Neotica",
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 80.dp)
        )


        if (expressaoGerada.isNotEmpty()) {

            Card(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(24.dp)
            ) {

                Text(
                    text = expressaoGerada,
                    modifier = Modifier.padding(24.dp)
                )

            }


            Button(
                onClick = { },
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 80.dp)
            ) {

                Text("Resolver Expressão")

            }

        } else {

            Button(
                onClick = {

                    expressaoGerada = "25 + (40 - 12)"

                },
                modifier = Modifier
                    .align(Alignment.Center)
            ) {

                Text("Gerar Expressão")

            }

        }

    }

}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    ExpressoesNumericasTheme {
        HomeScreen()
    }
}