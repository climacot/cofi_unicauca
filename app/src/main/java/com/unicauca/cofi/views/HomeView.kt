package com.unicauca.cofi.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.unicauca.cofi.R
import com.unicauca.cofi.ui.theme.FontColor
import com.unicauca.cofi.ui.theme.Purple40
import com.unicauca.cofi.ui.theme.Purple80
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(
    goToRegister: () -> Unit,
    goToAccount: () -> Unit,
    goToHome: () -> Unit,
    goToFinances: () -> Unit,
    goToAbout: () -> Unit
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Background wallpaper",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxWidth()
        )
        ModalNavigationDrawer(
            drawerState = drawerState,
            gesturesEnabled = true,
            drawerContent = {
                ModalDrawerSheet {
                    Text(text = "Drawer content")
                }
            },
            content = {
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
                                IconButton(onClick = {
                                    scope.launch {
                                        drawerState.apply {
                                            if (isClosed) {
                                                open()
                                            } else {
                                                close()
                                            }
                                        }
                                    }
                                }) {
                                    Icon(
                                        imageVector = Icons.Outlined.Menu,
                                        contentDescription = "Localized description"
                                    )
                                }
                            },
                            actions = {
                                IconButton(onClick = goToAccount) {
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
                                IconButton(
                                    onClick = goToHome,
                                ) {
                                    Icon(
                                        Icons.Outlined.Home,
                                        contentDescription = "Ir a inicio",
                                        tint = FontColor
                                    )
                                }
                                Text(text = "Inicio")
                            }
                            Spacer(modifier = Modifier.weight(1f))
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                IconButton(onClick = goToFinances) {
                                    Icon(
                                        Icons.Outlined.Info,
                                        contentDescription = "Ir a finanzas",
                                        tint = FontColor
                                    )
                                }
                                Text(text = "Finanzas")
                            }
                            Spacer(modifier = Modifier.weight(1f))
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                IconButton(onClick = goToAbout) {
                                    Icon(
                                        Icons.Outlined.Info,
                                        contentDescription = "Ir a comercio",
                                        tint = FontColor
                                    )
                                }
                                Text(text = "Acerca de")
                            }
                        }
                    },
                    floatingActionButton = {
                        FloatingActionButton(
                            onClick = goToRegister,
                            containerColor = Purple80
                        ) {
                            Icon(
                                Icons.Outlined.Edit,
                                contentDescription = "Agregar trabajador o registrar kilos recolectados"
                            )
                        }
                    }
                )
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
                text = "Mis fincas",
                fontSize = 22.sp,
                fontWeight = FontWeight.Normal
            )
            Spacer(modifier = Modifier.height(20.dp))
            Column(
                modifier = Modifier
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(5.dp)
                    )
                    .size(width = 200.dp, height = 120.dp)
                    .clip(shape = RoundedCornerShape(5.dp))
                    .border(
                        shape = RoundedCornerShape(5.dp),
                        border = BorderStroke(
                            width = 2.dp,
                            color = Purple40
                        )
                    )
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .height(80.dp),
                    contentScale = ContentScale.Crop,
                    contentDescription = "La loma",
                    painter = painterResource(
                        id = R.drawable.coffee
                    ),
                )
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxSize(1f)
                ) {
                    Text(text = "La loma")
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Rendimiento finca",
                fontSize = 22.sp,
                fontWeight = FontWeight.Normal
            )
            Spacer(modifier = Modifier.height(20.dp))
            Image(
                modifier = Modifier
                    .fillMaxWidth(1f),
                contentScale = ContentScale.Crop,
                contentDescription = "Grafica de barras",
                painter = painterResource(
                    id = R.drawable.grafica
                ),
            )
        }
    }
}

@Preview
@Composable
fun HomePreview() {
    HomeView(
        goToRegister = {},
        goToAccount = {},
        goToHome = {},
        goToAbout = {},
        goToFinances = {}
    )
}