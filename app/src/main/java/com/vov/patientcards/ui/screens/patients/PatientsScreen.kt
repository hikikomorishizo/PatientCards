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
import androidx.compose.runtime.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale


@Composable
fun PatientsScreen() {

    var sortType by remember { mutableStateOf(SortType.ALPHABET) }

    val patients = listOf(
        Patient(1, "Иван", "Алексеев", LocalDate.of(2024, 2, 1)),
        Patient(2, "Анна", "Архипова", LocalDate.of(2024, 2, 3)),
        Patient(3, "Борис", "Белов", LocalDate.of(2024, 1, 28)),
        Patient(4, "Вера", "Быкова", LocalDate.of(2024, 2, 3)),
    )

    val dateFormatter = DateTimeFormatter.ofPattern(
        "d MMMM yyyy",
        Locale("ru")
    )
    val groupedPatients = when (sortType) {

        SortType.ALPHABET -> {
            patients
                .sortedBy { it.lastName }
                .groupBy { it.lastName.first().toString() }
        }

        SortType.DATE -> {
            patients
                .sortedByDescending { it.createdAt }
                .groupBy { it.createdAt.format(dateFormatter) }
        }
    }

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

        Spacer(modifier = Modifier.height(12.dp))

        SortToggle(
            selected = sortType,
            onSelectedChange = { sortType = it }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // ====== LIST ======
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            groupedPatients.forEach { (header, patientsInGroup) ->

                item {
                    Text(
                        text = header,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleMedium
                    )
                }

                items(patientsInGroup) { patient ->
                    PatientRow(patient)
                }
            }
        }
    }
}
