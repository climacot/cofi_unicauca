package com.unicauca.cofi.views

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.firebase.auth.FirebaseUser

@Composable
fun AccountView(
    onSignOut: () -> Unit,
    user: FirebaseUser?
) {
    Scaffold(
        content = { paddingValues ->
            Surface(
                modifier = Modifier.padding(paddingValues)
            ) {
                Button(onClick = onSignOut) {
                    Text("Cerrar Sesión")
                }
            }
        }
    )
}