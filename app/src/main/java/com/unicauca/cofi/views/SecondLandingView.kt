package com.unicauca.cofi.views

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun SecondLandingView(goToLogin: () -> Unit, goBack: () -> Unit) {
    Column {
        Text(text = "Olvídate de tu cuaderno para registrar y calcular los pagos, cofi esta aquí para ayudarte y hacerlo por tí.")
        Button(onClick = goBack) {
            Text(text = "Anterior")
        }
        Button(onClick = goToLogin) {
            Text("Continuar")
        }
    }
}
