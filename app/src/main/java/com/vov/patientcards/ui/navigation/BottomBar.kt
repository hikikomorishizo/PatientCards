package com.vov.patientcards.ui.navigation

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Info

data class BottomNavItem(
    val screen: Screen,
    val icon: ImageVector
)

@Composable
fun BottomBar(navController: NavController) {

    val items = listOf(
        BottomNavItem(Screen.Home, Icons.Filled.Home),
        BottomNavItem(Screen.Patients, Icons.Filled.Person),
        BottomNavItem(Screen.Calendar, Icons.Filled.DateRange),
        BottomNavItem(Screen.About, Icons.Filled.Info)
    )

    val currentRoute =
        navController.currentBackStackEntryAsState().value?.destination?.route

    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.screen.route,
                onClick = {
                    navController.navigate(item.screen.route) {
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = null
                    )
                },
                label = {}
            )
        }
    }
}
