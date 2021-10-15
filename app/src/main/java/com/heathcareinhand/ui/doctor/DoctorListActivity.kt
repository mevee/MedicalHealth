package com.heathcareinhand.ui.doctor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.heathcareinhand.R
import com.heathcareinhand.databinding.ActivityDoctorListBinding

import androidx.core.app.ActivityOptionsCompat
import com.heathcareinhand.ui.doctor.filter.FilterDoctorFragment


class DoctorListActivity : AppCompatActivity() {
    private lateinit var doctorListAdapter: DoctorListAdapter
    lateinit var binding: ActivityDoctorListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_doctor_list)
        binding.toolDoctList.toolBack.setOnClickListener { onBackPressed() }
        binding.toolDoctList.home.setOnClickListener { onBackPressed() }
        binding.toolDoctList.toolTitle.text = "180 Doctors Found"

        val adapter = ArrayAdapter(
            this, R.layout.support_simple_spinner_dropdown_item, listOf(
                "--Select--",
                "Rating",
                "Popular",
                "Latest",
                "Free",
            )
        )
        binding.spFilter.adapter = adapter

        binding.cardFilters.setOnClickListener {
            showApplyFilterDialogue()
        }
        setDoctorList()
    }

    private fun showApplyFilterDialogue() {
        val dialogeFilter = FilterDoctorFragment.newInstance("","")
        dialogeFilter.show(supportFragmentManager,"filter")
    }

    private fun setDoctorList() {

        val doctorList =
            listOf(
                DoctorModel(
                    "https://akm-img-a-in.tosshub.com/indiatoday/images/story/202105/pexels-andrea-piacquadio-38088_1200x768.jpeg?JeOSG8xNDYZBlN67nbvDE.F8fe4RJoRl&size=770:433",
                    "Sushma",
                    "Urologist",
                    "7",
                    "500",
                    "500",
                    "500",
                    4.2f,
                    71,
                    "1",
                ),
                DoctorModel(
                    "https://akm-img-a-in.tosshub.com/indiatoday/images/story/202105/pexels-andrea-piacquadio-38088_1200x768.jpeg?JeOSG8xNDYZBlN67nbvDE.F8fe4RJoRl&size=770:433",
                    "Ravi Shankar",
                    "Urologist",
                    "4",
                    "410",
                    "201",
                    "403",
                    2.5f,
                    12,
                    "1",
                ),
                DoctorModel(
                    "https://akm-img-a-in.tosshub.com/indiatoday/images/story/202105/pexels-andrea-piacquadio-38088_1200x768.jpeg?JeOSG8xNDYZBlN67nbvDE.F8fe4RJoRl&size=770:433",
                    "Shsher",
                    "Gyncologies",
                    "2",
                    "500",
                    "100",
                    "250",
                    3.2f,
                    22,
                    "0",
                ),
            )

        doctorListAdapter = DoctorListAdapter(this, doctorList) { position, isClicked,sharedView ->
            if (isClicked)
            gotoDetailPage("dummy",sharedView)
        }
        binding.rvDoctList.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvDoctList.adapter = doctorListAdapter
    }

    fun gotoDetailPage(doctorId: String, sharedView: View) {
        val intentDetail  = (Intent(this, DoctorDetailActivity::class.java))

        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
            this,
            sharedView,
            "doctorOverView"
        )
        startActivity(intentDetail, options.toBundle())
    }
}