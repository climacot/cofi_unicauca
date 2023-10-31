package com.unicauca.cofi

import android.content.Intent
import android.os.Bundle
import android.util.Log
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
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.unicauca.cofi.ui.theme.CofiTheme
import com.unicauca.cofi.views.AccountView
import com.unicauca.cofi.views.FirstLandingView
import com.unicauca.cofi.views.HomeView
import com.unicauca.cofi.views.LoginView
import com.unicauca.cofi.views.SecondLandingView
import com.unicauca.cofi.views.register.RegisterView

class MainActivity : ComponentActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient

    companion object {
        private const val TAG = "GoogleActivity"
        private const val RC_SIGN_IN = 9001
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)
        auth = Firebase.auth
    }

    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser

        updateUI(currentUser)
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)

            try {
                val account = task.getResult(ApiException::class.java)!!
                firebaseAuthWithGoogle(account.idToken!!)
            } catch (e: ApiException) {
                Log.w(TAG, "Google sign in failed", e)
            }
        }
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)

        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    updateUI(null)
                }
            }
    }

    private fun signIn() {
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    private fun signOut() {
        auth.signOut()
        GoogleSignIn
            .getClient(applicationContext, GoogleSignInOptions.DEFAULT_SIGN_IN)
            .revokeAccess()
        updateUI(null)
    }

    private fun updateUI(user: FirebaseUser?) {
        setContent {
            CofiTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App(
                        user = user,
                        onSignOut = {
                            signOut()
                        },
                        onSignInWithGoogle = {
                            signIn()
                        },
                    )
                }
            }
        }
    }
}

@Composable
fun App(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    onSignInWithGoogle: () -> Unit,
    onSignOut: () -> Unit,
    user: FirebaseUser?
) {
    val startDestination = if (user != null) "home" else "first_landing"

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
                    onSignInWithGoogle()
                }
            )
        }
        composable("home") {
            HomeView(
                goToRegister = {
                    navController.navigate("register")
                },
                goToAccount = {
                    navController.navigate("account")
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
        composable("account") {
            AccountView(
                user = user,
                onSignOut = {
                    onSignOut()
                }
            )
        }
    }
}