package com.example.templateapp.view.component

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.templateapp.R
import com.example.templateapp.model.BottomNavBarData

@Composable
fun BottomNavBar(
    navController: NavController
) {
    val currentRoute = navController.currentBackStackEntryAsState()?.value?.destination?.route

    NavigationBar(
        containerColor = Color.White
    ) {
        listOf(
            BottomNavBarData.Home,
            BottomNavBarData.Cart,
            BottomNavBarData.History,
            BottomNavBarData.Profile
        ).forEach { screen->
            NavigationBarItem(
                selected = currentRoute == screen.route,
                onClick = {
                    if (currentRoute != screen.route) {
                        navController.navigate(screen.route) {
                            popUpTo(navController.graph.startDestinationId) {saveState = true}
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(id = screen.icon),
                        contentDescription = screen.title,
                        modifier = Modifier.size(24.dp)
                    )
                },
                label = { Text(text = screen.title) },
                colors = NavigationBarItemDefaults.colors(
                    selectedTextColor = colorResource(R.color.ocean_boat_blue),
                    unselectedTextColor = colorResource(R.color.old_silver),
                    selectedIconColor = colorResource(R.color.ocean_boat_blue),
                    unselectedIconColor = colorResource(R.color.old_silver),
                    indicatorColor = Color.Transparent
                )

            )
        }
    }
}

@Preview
@Composable
private fun View() {
    val navController = rememberNavController()
    BottomNavBar(navController = navController)

}