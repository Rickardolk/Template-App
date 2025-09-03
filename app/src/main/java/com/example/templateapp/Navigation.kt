package com.example.templateapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.templateapp.screen.ForgotPasswordScreen
import com.example.templateapp.screen.HomeScreen
import com.example.templateapp.screen.LoginScreen
import com.example.templateapp.screen.RegisterScreen

@Composable
fun Navigation() {
    val context = LocalContext.current
    val navController = rememberNavController()

    NavHost(
        startDestination = "login",
        navController = navController
    ) {
        composable("login") {
            LoginScreen(
                navController = navController,
                context = context
            )
        }

        composable("register") {
            RegisterScreen(
                navController = navController,
                context = context
            )
        }

        composable("home") {
            HomeScreen()
        }

        composable("forgot password") {
            ForgotPasswordScreen(
                navController = navController,
                context = context
            )
        }
    }

}