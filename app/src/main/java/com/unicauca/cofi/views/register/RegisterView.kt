package com.unicauca.cofi.views.register

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.unicauca.cofi.R
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterView(onBack: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Background wallpaper",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxWidth()
        )
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = Color.Transparent,
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Transparent
                    ),
                    title = {
                        Text(text = "La loma")
                    },
                    navigationIcon = {
                        IconButton(onClick = {}) {
                            Icon(
                                imageVector = Icons.Outlined.ArrowBack,
                                contentDescription = "Go to back"
                            )
                        }
                    },
                )
            },
            content = { paddingValues ->
                Content(
                    paddingValues = paddingValues
                )
            },
            bottomBar = {
                BottomAppBar(
                    modifier = Modifier.fillMaxWidth(),
                    contentPadding = PaddingValues(
                        horizontal = 10.dp
                    )
                ) {
                    OutlinedButton(onClick = onBack) {
                        Text(text = "Cancelar")
                    }
                    Spacer(modifier = Modifier.width(5.dp))
                    Button(onClick = {}) {
                        Text(text = "Guardar")
                    }
                }
            }
        )
    }
}

fun getDateTime(): String {
    val dateFormat = SimpleDateFormat("d MMM yyy", Locale.US)
    val date = dateFormat.format(Date())
    return date.toString()
}

@Composable
fun Content(
    paddingValues: PaddingValues
) {
    Column(
        modifier = Modifier
            .fillMaxSize(1f)
            .padding(paddingValues)
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxSize(1f)
        ) {
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxSize(1f)
                    .clip(RoundedCornerShape(5.dp))
                    .border(
                        border = BorderStroke(1.dp, Color.Black),
                        shape = RoundedCornerShape(5.dp)
                    )
            ) {
                Column(
                    modifier = Modifier.padding(10.dp)
                ) {
                    Text(
                        text = getDateTime(),
                        textAlign = TextAlign.End,
                        modifier = Modifier.fillMaxWidth(1f)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "Anotar trabajador")
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(
                        modifier = Modifier.fillMaxWidth(1f),
                        onClick = {}
                    ) {
                        Text(text = "Agregar trabajador")
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun RegisterPreview() {
    RegisterView(onBack = {})
}