package com.vov.patientcards

import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.vov.patientcards.ui.theme.PatientCardsTheme
import com.vov.patientcards.ui.SplashScreen
import com.vov.patientcards.ui.navigation.BottomBar
import com.vov.patientcards.ui.navigation.AppNavHost
import androidx.compose.foundation.layout.Box

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val navController = rememberNavController()

            Scaffold(
                bottomBar = {
                    BottomBar(navController)
                }
            ) { padding ->
                Box(
                    modifier = Modifier.padding(padding)
                ) {
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