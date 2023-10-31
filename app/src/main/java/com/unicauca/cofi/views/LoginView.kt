package com.unicauca.cofi.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.unicauca.cofi.R

@Composable
fun LoginView(onLogin: () -> Unit) {
    var bgColor = Color(0xFFF8FAF6)
    var primaryColor = Color(0xFF4FA884)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(bgColor),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Box(Modifier.fillMaxWidth(), Alignment.Center) {
            Image(
                painter = painterResource(id = R.drawable.background),
                contentDescription = "",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillBounds,
            )
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "",
                modifier = Modifier.padding(top = 50.dp)
            )
        }
        Spacer(
            modifier = Modifier.weight(4f)
        )
        Row(
            modifier = Modifier.padding(bottom = 80.dp)
        ) {
            OutlinedButton(
                onClick = onLogin,
                shape = CircleShape,
                modifier = Modifier.background(color = Color.White, shape = CircleShape),
                border= BorderStroke(width = 2.dp, color = primaryColor),
                contentPadding = PaddingValues(horizontal = 40.dp, vertical = 10.dp)
            ) {
                Image(painter = painterResource(id = R.drawable.google_icon), contentDescription = "")
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Iniciar con google", color = Color.Gray)
            }
        }
    }
}

@Preview
@Composable
fun prevLogin() {
    LoginView {
    }
}