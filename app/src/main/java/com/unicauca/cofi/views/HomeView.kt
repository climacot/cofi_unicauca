package com.unicauca.cofi.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(onLogout: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Top app bar")
                }
            )
        },
        content = { paddingValues ->
            Content(
                paddingValues = paddingValues,
                onLogout = onLogout
            )
        },
        bottomBar = {
            BottomAppBar {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "Bottom app bar",
                )
            }
        },
    )
}

@Composable
fun Content(paddingValues: PaddingValues, onLogout: () -> Unit) {
    Column(
        modifier = Modifier.padding(paddingValues)
    ) {
        Button(onClick = onLogout) {
            Text(text = "Cerrar sesión")
        }
    }
}

@Preview
@Composable
fun HomePreview() {
    HomeView(onLogout = {})
}