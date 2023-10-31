package com.unicauca.cofi.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.unicauca.cofi.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(
    onLogout: () -> Unit,
    goToRegister: () -> Unit
) {
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
                CenterAlignedTopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Transparent
                    ),
                    title = {
                        Image(
                            painter = painterResource(id = R.drawable.cofi_appbar),
                            contentDescription = "Logo cofi"
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = {}) {
                            Icon(
                                imageVector = Icons.Outlined.Menu,
                                contentDescription = "Localized description"
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = onLogout) {
                            Icon(
                                imageVector = Icons.Outlined.AccountCircle,
                                contentDescription = "Localized description"
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
                        horizontal = 50.dp
                    )
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        IconButton(onClick = {}) {
                            Icon(
                                Icons.Outlined.Home,
                                contentDescription = "Ir a inicio"
                            )
                        }
                        Text(text = "Inicio")
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        IconButton(onClick = {}) {
                            Icon(
                                Icons.Outlined.Info,
                                contentDescription = "Ir a finanzas"
                            )
                        }
                        Text(text = "Finanzas")
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        IconButton(onClick = {}) {
                            Icon(
                                Icons.Outlined.CheckCircle,
                                contentDescription = "Ir a comercio"
                            )
                        }
                        Text(text = "Comercio")
                    }
                }
            },
            floatingActionButton = {
                FloatingActionButton(onClick = goToRegister) {
                    Icon(
                        Icons.Outlined.Edit,
                        contentDescription = "Agregar trabajador o registrar kilos recolectados"
                    )
                }
            }
        )
    }
}

@Composable
fun Content(
    paddingValues: PaddingValues,
) {
    Column(
        modifier = Modifier.padding(paddingValues),
    ) {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            Text(
                text = "Mi finca",
                fontSize = 22.sp,
                fontWeight = FontWeight.Normal
            )
        }
    }
}

@Preview
@Composable
fun HomePreview() {
    HomeView(
        goToRegister = {},
        onLogout = {}
    )
}