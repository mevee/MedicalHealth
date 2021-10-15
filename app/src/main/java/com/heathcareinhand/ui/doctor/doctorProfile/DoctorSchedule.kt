package com.heathcareinhand.ui.doctor.doctorProfile

data class DoctorScheduleEditable(
    val date: String,
    val day: String,
    val timeSlots: MutableList<String>,
)