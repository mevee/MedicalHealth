package com.heathcareinhand.ui.doctor

data class DoctorModel(
    val image: String,
    val name: String,
    val expertise: String,
    val experience: String,
    val chatRate: String,
    val callAudioRate: String,
    val callVideoRate: String,
    val rate: Float,
    val totalRating:Int,
    val isVerified: String,
)