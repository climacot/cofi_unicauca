package com.unicauca.cofi.views.finances

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.unit.dp
import com.unicauca.cofi.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FinancasView(
    goToHome: () -> Unit,
    goToFinances: () -> Unit,
    goToAbout: () -> Unit
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
                        IconButton(onClick = goToHome) {
                            Icon(
                                Icons.Outlined.Home,
                                contentDescription = "Ir a inicio"
                            )
                        }
                        Text(text = "Inicio")
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        IconButton(onClick = goToFinances) {
                            Icon(
                                Icons.Outlined.Info,
                                contentDescription = "Ir a finanzas"
                            )
                        }
                        Text(text = "Finanzas")
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        IconButton(onClick = goToAbout) {
                            Icon(
                                Icons.Outlined.CheckCircle,
                                contentDescription = "Ir a comercio"
                            )
                        }
                        Text(text = "Comercio")
                    }
                }
            }
        )
    }
}

@Composable
fun Content(paddingValues: PaddingValues) {
    Column(
        modifier = Modifier.padding(paddingValues),
    ) {}
}