package com.unicauca.cofi.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
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
                    IconButton(onClick = {}) {
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
                paddingValues = paddingValues,
                onLogout = onLogout,
                goToRegister = goToRegister
            )
        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(
                    horizontal = 50.dp
                )
            ) {
                IconButton(onClick = {}) {
                    Icon(
                        Icons.Outlined.Home,
                        contentDescription = "Ir a inicio"
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = {}) {
                    Icon(
                        Icons.Outlined.Info,
                        contentDescription = "Ir a inicio"
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = {}) {
                    Icon(
                        Icons.Outlined.CheckCircle,
                        contentDescription = "Ir a inicio"
                    )
                }
            }
        },
    )
}

@Composable
fun Content(
    paddingValues: PaddingValues,
    onLogout: () -> Unit, goToRegister: () -> Unit
) {
    Column(
        modifier = Modifier.padding(paddingValues)
    ) {
        Text(
            text = "Mi finca",
            fontSize = 22.sp,
            fontWeight = FontWeight.Normal
        )
        Button(onClick = onLogout) {
            Text(text = "Cerrar sesión")

        }
        Button(onClick = goToRegister) {
            Text(text = "Registrar kilos recolectados")
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