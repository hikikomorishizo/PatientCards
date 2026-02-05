package com.vov.patientcards.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.vov.patientcards.ui.screens.home.HomeScreen
import com.vov.patientcards.ui.screens.patients.PatientsScreen
import com.vov.patientcards.ui.screens.calendar.CalendarScreen
import com.vov.patientcards.ui.screens.about.AboutScreen

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen()
        }
        composable(Screen.Patients.route) {
            PatientsScreen()
        }
        composable(Screen.Calendar.route) {
            CalendarScreen()
        }
        composable(Screen.About.route) {
            AboutScreen()
        }
    }
}
