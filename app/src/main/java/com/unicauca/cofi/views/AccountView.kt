package com.unicauca.cofi.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.firebase.auth.FirebaseUser

@Composable
fun AccountView(
    onSignOut: () -> Unit,
    goToBack: () -> Unit,
    user: FirebaseUser?
) {
    Layout(
        goToBack = goToBack,
        content = {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .background(Color.Transparent)
                    .fillMaxSize()
            ) {
                Text(text = user?.displayName ?: "Sin nombre")
                Spacer(modifier = Modifier.height(10.dp))
                Button(onClick = onSignOut) {
                    Text("Cerrar Sesión")
                }
            }
        }
    )
}

@Composable
@Preview
fun PreviewAccountView() {
    AccountView(
        onSignOut = {},
        user = null,
        goToBack = {}
    )
}