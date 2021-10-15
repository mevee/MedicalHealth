package com.heathcareinhand.ui.doctor.doctorProfile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.heathcareinhand.R
import com.heathcareinhand.databinding.ActivityDoctorProfileBinding
import com.heathcareinhand.databinding.ActivitySignupDoctorBinding
import com.heathcareinhand.ui.common.MultiSelectAdapter
import com.heathcareinhand.ui.common.SelectModel
import com.heathcareinhand.ui.doctor.DoctorSchedule
import com.heathcareinhand.ui.doctor.DoctorTimeTableAdapter
import com.heathcareinhand.ui.doctor.filter.FilterDoctorFragment
import com.heathcareinhand.ui.home.OfferingModel

class DoctorProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDoctorProfileBinding

    private lateinit var specielistAdapter: MultiSelectAdapter
    private lateinit var experienceAdapter: ExperienceAdapter
    private lateinit var doctorTimeTableAdapter: DoctorEditableTimeTableAdapter
    private lateinit var educationAdapter: EducationAdapter
    private var selectedDay: String = ""
    private var mTimeTableList: MutableList<DoctorScheduleEditable> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_doctor_profile)

        binding.toolDoctorProfile.toolBack.setOnClickListener { onBackPressed() }
        binding.toolDoctorProfile.home.setOnClickListener { onBackPressed() }
        binding.toolDoctorProfile.toolTitle.text = "Profile Information"
        val specielity = ArrayAdapter(
            this, R.layout.support_simple_spinner_dropdown_item, listOf(
                "Technologiest",
                "Dermologistr",
                "Cardiologist",
                "Dietian",
                "Dermologistr",
                "Cardiologist",
                "Dietian",
            )
        )

        val adapter = ArrayAdapter(
            this, R.layout.support_simple_spinner_dropdown_item, listOf(
                "0-5",
                "5-10",
                "10-15",
                "15-20",
                "20-25",
                "25-30",
            )
        )

        val genderAdapter = ArrayAdapter(
            this, R.layout.support_simple_spinner_dropdown_item, listOf(
                "Male",
                "Female",
                "Other",
            )
        )

        binding.spExperience.adapter = adapter
        binding.spSpecielity.adapter = specielity
        binding.spGender.adapter = genderAdapter

        binding.cardAddExperience.setOnClickListener {
            addExperienceDialogues()
        }
        binding.cardAddTime.setOnClickListener {
            if (selectedDay == null || selectedDay.isEmpty()) {

                Toast.makeText(this, "Day is not selected", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            addDay(selectedDay)
            addTimingDialogues()
        }
        binding.cardAddducation.setOnClickListener {
            addEducatuionDialogues()
        }

        setSpecielist()
        setExperience()
        setDoctorCalender()
        setEducations()
    }

    private fun addTimingDialogues() {
        val dialogeFilter = AddTimeFragment.newInstance(selectedDay, "")
        dialogeFilter.show(supportFragmentManager, "filter")

    }

    private fun addEducatuionDialogues() {
        val dialogeFilter = AddEducationFragment.newInstance("", "")
        dialogeFilter.show(supportFragmentManager, "filter")

    }

    private fun addExperienceDialogues() {
        val dialogeFilter = AddExperienceFragment.newInstance("", "")
        dialogeFilter.show(supportFragmentManager, "filter")

    }

    private fun setSpecielist() {
        val calenderList = listOf(
            SelectModel(
                "Intensive care",
                1
            ),
            SelectModel(
                "Critical care",
                3
            ),
            SelectModel(
                "Intensive care",
                1
            ),
            SelectModel(
                "Critical care",
                3
            ),
            SelectModel(
                "Intensive care",
                1
            ),
            SelectModel(
                "Critical care",
                3
            ),
        )

        binding.rvExpertise.isNestedScrollingEnabled = false
        specielistAdapter = MultiSelectAdapter(this, calenderList) { position, selectedValue -> }
        binding.rvExpertise.adapter = specielistAdapter
        binding.rvExpertise.layoutManager =
            StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL)

    }

    private fun setExperience() {
        val calenderList = mutableListOf(
            OfferingModel(
                "Intensive care",
                "Intensive care",
                "Intensive care",
            ),
            OfferingModel(
                "Intensive care",
                "Intensive care",
                "Intensive care",
            ),
        )

        binding.rvExperience.isNestedScrollingEnabled = false

        experienceAdapter = ExperienceAdapter(this, calenderList) { position, selectedValue -> }
        binding.rvExperience.adapter = experienceAdapter
        binding.rvExperience.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    }

    private fun setEducations() {
        val calenderList = mutableListOf(
            OfferingModel(
                "16 Aug 2021",
                "16 Aug 2021",
                "MON",
            ),
            OfferingModel(
                "16 Aug 2021",
                "16 Aug 2021",
                "MON",
            ),
        )
        educationAdapter = EducationAdapter(this, calenderList) { position, selectedValue ->
        }

        binding.rvEducation.adapter = educationAdapter
        binding.rvEducation.isNestedScrollingEnabled = false
        binding.rvEducation.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    fun addDay(dayName: String) {

        for (index in mTimeTableList.indices) {
            val day = mTimeTableList[index]
            if (day.day.toLowerCase().contains(dayName.toLowerCase())) {
                day.timeSlots.add("01:00 AM-09:00 PM")
                doctorTimeTableAdapter.setSelection(index)
            }
        }
    }

    private fun setDoctorCalender() {
        val calenderList = listOf(
            DoctorScheduleEditable(
                "16 Aug 2021",
                "MON",
                mutableListOf()
            ),
            DoctorScheduleEditable(
                "17 Aug 2021",
                "TUE",
                mutableListOf()
            ),
            DoctorScheduleEditable(
                "18 Aug 2021",
                "WED",
                mutableListOf()
            ),
            DoctorScheduleEditable(
                "19 Aug 2021",
                "THU",
                mutableListOf("11:00 AM-12:00 PM")
            ),
            DoctorScheduleEditable(
                "20 Aug 2021",
                "FRI",
                mutableListOf()
            ),
            DoctorScheduleEditable(
                "21 Aug 2021",
                "SAT",
                mutableListOf()
            )

        )
        mTimeTableList.addAll(calenderList)
        doctorTimeTableAdapter =
            DoctorEditableTimeTableAdapter(this, mTimeTableList) { position, selectedValue ->
                selectedDay = selectedValue
                Log.d("PROFILEEEE", selectedDay)
            }

        binding.rvCalender.adapter = doctorTimeTableAdapter
        binding.rvCalender.isNestedScrollingEnabled = false

        binding.rvCalender.layoutManager =
//            StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL)
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }


}