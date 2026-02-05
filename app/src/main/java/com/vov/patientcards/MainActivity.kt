package com.vov.patientcards

import androidx.compose.runtime.*
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.vov.patientcards.ui.theme.PatientCardsTheme
import com.vov.patientcards.ui.navigation.BottomBar
import com.vov.patientcards.ui.navigation.AppNavHost
import androidx.compose.foundation.layout.Box
import androidx.navigation.compose.currentBackStackEntryAsState
import com.vov.patientcards.ui.navigation.Screen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val navController = rememberNavController()

            val currentBackStack by navController.currentBackStackEntryAsState()
            val currentRoute = currentBackStack?.destination?.route

            Scaffold(
                bottomBar = {
                    if (currentRoute != Screen.Splash.route) {
                        BottomBar(navController)
                    }
                }
            ) { padding ->
                Box(modifier = Modifier.padding(padding)) {
                    AppNavHost(navController)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PatientCardsTheme {
        Greeting("Android")
    }
}