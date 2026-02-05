package com.vov.patientcards.ui.screens.patients

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun PatientsScreen() {

    val patients = listOf(
        Patient(1, "Иван", "Алексеев"),
        Patient(2, "Анна", "Архипова"),
        Patient(3, "Борис", "Белов"),
        Patient(4, "Вера", "Быкова"),
    )

    val groupedPatients = patients.groupBy { it.lastName.first() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        // ====== HEADER ======
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Пациенты",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.weight(1f)
            )

            Button(onClick = { /* TODO: add patient */ }) {
                Text("Добавить")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // ====== LIST ======
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            groupedPatients.forEach { (letter, patientsByLetter) ->

                item {
                    Text(
                        text = letter.toString(),
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleMedium
                    )
                }

                items(patientsByLetter) { patient ->
                    PatientRow(patient)
                }
            }
        }
    }
}
