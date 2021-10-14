package com.heathcareinhand.ui.doctor

data class DoctorSchedule(
    val date: String,
    val day: String,
    val timeSlots: List<String>,
)