package com.heathcareinhand.ui.doctor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import coil.load
import coil.transform.CircleCropTransformation
import com.heathcareinhand.R
import com.heathcareinhand.databinding.ActivityDoctorDetailBinding
import com.heathcareinhand.ui.HomeActivity
import com.heathcareinhand.ui.home.OfferingModel
import com.heathcareinhand.ui.home.TestimonialsAdapter

class DoctorDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDoctorDetailBinding
    private lateinit var doctorTimeTableAdapter: DoctorTimeTableAdapter
    private lateinit var testimonialAdapter: TestimonialsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_doctor_detail)
        binding.toolDoctList.toolBack.setOnClickListener { onBackPressed() }
        binding.toolDoctList.home.setOnClickListener { goToHomePage() }
        binding.toolDoctList.toolTitle.text = "Saxena Chowdry"

        binding.ivDoctor.load(
            "https://akm-img-a-in.tosshub.com/indiatoday/images/story/202105/pexels-andrea-piacquadio-38088_1200x768.jpeg?JeOSG8xNDYZBlN67nbvDE.F8fe4RJoRl&size=770:433",
        ) {
            crossfade(true)
            transformations(CircleCropTransformation())
        }

        setDoctorTimeTable()
    }

    private fun setDoctorTimeTable() {
        val calenderList = listOf(
            DoctorSchedule(
                "16 Aug 2021",
                "MON",
                listOf("11:00AM-02:00PM", "12:00AM-04:00PM", "06:00AM-09:00PM")
            ),
            DoctorSchedule(
                "17 Aug 2021",
                "TUE",
                listOf("01:00AM-02:00PM", "02:00AM-02:00PM", "03:00AM-04:00PM")
            ),
            DoctorSchedule(
                "18 Aug 2021",
                "WED",
                listOf("11:00AM-02:00PM", "11:00AM-02:00PM", "11:00AM-02:00PM")
            ),
            DoctorSchedule(
                "19 Aug 2021",
                "THU",
                listOf("11:00AM-02:00PM", "11:00AM-02:00PM", "11:00AM-02:00PM")
            ),
            DoctorSchedule(
                "20 Aug 2021",
                "FRI",
                listOf("11:00AM-02:00PM", "11:00AM-02:00PM", "11:00AM-02:00PM")
            ),
            DoctorSchedule(
                "21 Aug 2021",
                "SAT",
                listOf("11:00AM-02:00PM", "11:00AM-02:00PM", "11:00AM-02:00PM")
            )

        )
        doctorTimeTableAdapter = DoctorTimeTableAdapter(this,calenderList){
            position, selectedValue ->
            binding.tvBookAppointment.text = "Book Appointment of \n$selectedValue"

        }
        binding.rvCalenderList.adapter = doctorTimeTableAdapter
        binding.rvCalenderList.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        setTestimonials()
    }

    private fun setTestimonials() {
        val sideMenuOptionsList =
            listOf(
                OfferingModel(
                    "https://images.unsplash.com/photo-1494790108377-be9c29b29330?ixid=MnwxMjA3fDB8MHxzZWFyY2h8M3x8dXNlciUyMHByb2ZpbGV8ZW58MHx8MHx8&ixlib=rb-1.2.1&w=1000&q=80",
                    "Doctors",
                    "Confirmed appointments"
                ),
                OfferingModel(
                    "https://www.nursingworld.org/~4ad751/globalassets/practiceandpolicy/workforce/what-is-nursing/largeimage-anais-42.jpg",
                    "Nursing",
                    "Confirmed appointments"
                ),
                OfferingModel(
                    "https://college.mayo.edu/media/mccms/content-assets/academics/explore-health-care-careers/laboratory-sciences-career-3635221-0065-hero-tablet.jpg",
                    "Labs",
                    "Confirmed appointments"
                ),
                OfferingModel(
                    "https://www.kotharimedical.com/wp-content/uploads/2021/06/ambulance-img2.png",
                    "Ambulance",
                    "Confirmed appointments"
                ),
            )
        testimonialAdapter = TestimonialsAdapter(this, sideMenuOptionsList)
        binding.rvTestimonials.layoutManager =
            StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)
        binding.rvTestimonials.adapter = testimonialAdapter
    }
    fun goToHomePage() {
        startActivity(Intent(this, HomeActivity::class.java))
        finishAffinity()
    }
}