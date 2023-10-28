package com.unicauca.cofi.views

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun FirstLandingView(goToSecondLanding: () -> Unit) {
    Column {
        Text(text = "Ahorra tiempo calculando automáticamente el pago de tus trabajadores.")
        Button(onClick = goToSecondLanding) {
            Text("Continuar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FirstLandingPreview() {
    FirstLandingView(goToSecondLanding = {})
}