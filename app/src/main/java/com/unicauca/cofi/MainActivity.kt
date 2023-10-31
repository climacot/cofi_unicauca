package com.unicauca.cofi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.unicauca.cofi.ui.theme.CofiTheme
import com.unicauca.cofi.views.FirstLandingView
import com.unicauca.cofi.views.HomeView
import com.unicauca.cofi.views.LoginView
import com.unicauca.cofi.views.register.RegisterView
import com.unicauca.cofi.views.SecondLandingView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CofiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "first_landing"
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable("first_landing") {
            FirstLandingView(
                goToSecondLanding = {
                    navController.navigate("second_landing")
                }
            )
        }
        composable("second_landing") {
            SecondLandingView(
                goBack = {
                    navController.popBackStack()
                },
                goToLogin = {
                    navController.navigate("login")
                }
            )
        }
        composable("login") {
            LoginView(
                onLogin = {
                    navController.navigate("home")
                }
            )
        }
        composable("home") {
            HomeView(
                goToRegister = {
                    navController.navigate("register")
                },
                onLogout = {
                    navController.popBackStack()
                }
            )
        }
        composable("register") {
            RegisterView(
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}