package com.vov.patientcards.ui.screens.patients

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PatientRow(patient: Patient) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "${patient.lastName} ${patient.firstName}",
            modifier = Modifier.weight(1f)
        )

        OutlinedButton(
            onClick = { /* TODO: open patient */ }
        ) {
            Text("Открыть")
        }
    }
}
