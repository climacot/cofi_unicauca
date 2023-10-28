package com.unicauca.cofi.views

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun RegisterView(onBack: () -> Unit) {
    Column {
        Button(onClick = onBack) {
            Text(text = "Cancelar")
        }
    }
}