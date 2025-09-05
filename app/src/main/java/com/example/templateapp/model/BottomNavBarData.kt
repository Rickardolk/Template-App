package com.example.templateapp.model

import com.example.templateapp.R


sealed class BottomNavBarData (
    val route: String,
    val title: String,
    val icon: Int
) {
    data object Home: BottomNavBarData("home", "Home", R.drawable.ic_home)
    data object Cart: BottomNavBarData("cart", "Cart", R.drawable.ic_cart)
    data object History: BottomNavBarData("history", "History", R.drawable.ic_history)
    data object Profile: BottomNavBarData("profile", "Profile", R.drawable.ic_profile)
}