package com.vov.patientcards.ui.screens.patients

import java.time.LocalDate

data class Patient(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val createdAt: LocalDate
)
