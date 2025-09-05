package com.example.templateapp

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.templateapp.model.BottomNavBarData
import com.example.templateapp.view.component.BottomNavBar
import com.example.templateapp.view.screen.CartScreen
import com.example.templateapp.view.screen.ForgotPasswordScreen
import com.example.templateapp.view.screen.HistoryScreen
import com.example.templateapp.view.screen.HomeScreen
import com.example.templateapp.view.screen.LoginScreen
import com.example.templateapp.view.screen.ProfileScreen
import com.example.templateapp.view.screen.RegisterScreen

@Composable
fun Navigation() {
    val context = LocalContext.current
    val navController = rememberNavController()
    val currentRoute = navController.currentBackStackEntryAsState()?.value?.destination?.route

    Scaffold(
        bottomBar = {
            if (currentRoute in listOf(
                    BottomNavBarData.Home.route,
                    BottomNavBarData.Cart.route,
                    BottomNavBarData.History.route,
                    BottomNavBarData.Profile.route
            ))
                BottomNavBar(navController)
        }
    ) { innerPadding ->
        NavHost(
            startDestination = "login",
            navController = navController,
            modifier = Modifier.padding(innerPadding)
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

            composable("forgot password") {
                ForgotPasswordScreen(
                    navController = navController,
                    context = context
                )
            }

            composable("home") {
                HomeScreen()
            }

            composable("cart") {
                CartScreen()
            }

            composable("history") {
                HistoryScreen()
            }

            composable("profile") {
                ProfileScreen()
            }
        }
    }
}