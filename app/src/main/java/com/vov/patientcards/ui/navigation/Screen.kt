package com.vov.patientcards.ui.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Home : Screen("home")
    object Patients : Screen("patients")
    object Calendar : Screen("calendar")
    object About : Screen("about")
}
