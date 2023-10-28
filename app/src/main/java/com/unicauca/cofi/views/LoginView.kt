package com.unicauca.cofi.views

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun LoginView(onLogin: () -> Unit) {
    Column {
        Text(text = "cofi")
        Button(onClick = onLogin) {
            Text(text = "Iniciar con google")
        }
    }
}