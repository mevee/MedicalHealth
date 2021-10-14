package com.heathcareinhand.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import coil.load
import coil.transform.CircleCropTransformation
import com.heathcareinhand.R
import com.heathcareinhand.databinding.ActivityHomeBinding
import com.heathcareinhand.ui.auth.SignupDoctorActivity
import com.heathcareinhand.ui.common.SliderAdapter
import com.heathcareinhand.ui.common.SliderModel
import com.heathcareinhand.ui.doctor.DoctorListActivity
import com.heathcareinhand.ui.home.*

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var sideMenuAdapter: SideMenuAdapter
    private lateinit var sliderAdapter: SliderAdapter
    private lateinit var offeringAdapter: OfferingsAdapter
    private lateinit var spotLightAdapter: OurServicesAdapter
    private lateinit var testimonialAdapter: TestimonialsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        binding.sideLay.ivProfileImage.load(
            "https://akm-img-a-in.tosshub.com/indiatoday/images/story/202105/pexels-andrea-piacquadio-38088_1200x768.jpeg?JeOSG8xNDYZBlN67nbvDE.F8fe4RJoRl&size=770:433",
        ) {
            crossfade(true)
            transformations(CircleCropTransformation())
        }


        binding.ivMenu.setOnClickListener {
            openDrawer()
        }

        setHomeSlider()
        setSideMenu()
        setOfferings()
        setSpotLight()
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

    private fun setOfferings() {
        val sideMenuOptionsList =
            listOf(
                OfferingModel(
                    "https://media.istockphoto.com/photos/doctor-holding-digital-tablet-at-meeting-room-picture-id1189304032?k=20&m=1189304032&s=612x612&w=0&h=ovTNnR0JX2cRZkzMBed9exRO_PamZLlysLDFkXesr4Q=",
                    "Doctors",
                    "180+"
                ),
                OfferingModel(
                    "https://www.nursingworld.org/~4ad751/globalassets/practiceandpolicy/workforce/what-is-nursing/largeimage-anais-42.jpg",
                    "Nursing",
                    "80+"
                ),
                OfferingModel(
                    "https://college.mayo.edu/media/mccms/content-assets/academics/explore-health-care-careers/laboratory-sciences-career-3635221-0065-hero-tablet.jpg",
                    "Labs",
                    "100+"
                ),
                OfferingModel(
                    "https://www.kotharimedical.com/wp-content/uploads/2021/06/ambulance-img2.png",
                    "Ambulance",
                    "140+"
                ),
                OfferingModel(
                    "https://images.theconversation.com/files/369567/original/file-20201116-23-18wlnv.jpg?ixlib=rb-1.1.0&q=45&auto=format&w=1200&h=1200.0&fit=crop",
                    "Medicines",
                    "180+"
                ),
                OfferingModel(
                    "https://static.vecteezy.com/system/resources/previews/001/185/153/non_2x/medical-equipment-and-medicine-design-vector.jpg",
                    "Equipments",
                    "100+"
                ),
            )
        offeringAdapter = OfferingsAdapter(this, sideMenuOptionsList) { position, isClicked ->
            if (isClicked)
                startActivity(Intent(this, DoctorListActivity::class.java))

        }
        binding.rvOurOfferings.layoutManager =
            StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        binding.rvOurOfferings.adapter = offeringAdapter
    }

    private fun setSpotLight() {
        val sideMenuOptionsList =
            listOf(
                OfferingModel(
                    "https://i0.wp.com/post.healthline.com/wp-content/uploads/2020/03/Drug_Interactions_A_Guide_for_Consumers-732x549-thumbnail-732x549.jpg?w=756&h=567",
                    "We Guide You",
                    "Confirmed appointments"
                ),
                OfferingModel(
                    "https://www.laingbuissonnews.com/wp-content/uploads/sites/3/2021/02/doctor-india_4.jpg",
                    "Treatment in India",
                    "Confirmed appointments"
                ),
                OfferingModel(
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTqgnXQfIEzSrDNKsfBoiblsOwux2x-tyCmXQ&usqp=CAU",
                    "Treatment Abroad",
                    "Confirmed appointments"
                ),
                OfferingModel(
                    "https://www.piceeducare.com/wp-content/uploads/2020/03/Study-MBBS-Abroad-For-Indian-Students-At-Low-Cost.jpeg",
                    "MBBS Abroad",
                    "Confirmed appointments"
                ),
                OfferingModel(
                    "https://images.theconversation.com/files/369567/original/file-20201116-23-18wlnv.jpg?ixlib=rb-1.1.0&q=45&auto=format&w=1200&h=1200.0&fit=crop",
                    "We help You",
                    "Confirmed appointments"
                ),
                OfferingModel(
                    "https://3.imimg.com/data3/VE/GM/MY-9448016/institutional-service-500x500.jpg",
                    "Institutional Services",
                    "Confirmed appointments"
                ),
            )
        spotLightAdapter = OurServicesAdapter(this, sideMenuOptionsList)
        binding.rvSpotLight.layoutManager =
            StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)
        binding.rvSpotLight.adapter = spotLightAdapter
    }

    private fun setHomeSlider() {
        val sideMenuOptionsList =
            listOf(
                SliderModel(
                    "https://img.freepik.com/free-psd/medical-aid-banner-page-template_23-2148969688.jpg?size=626&ext=jpg",
                    "Profile"
                ),
            )
        sliderAdapter = SliderAdapter(this, sideMenuOptionsList)
        binding.vpSlider.adapter = sliderAdapter
    }

    private fun openDrawer() {
        binding.drawerHome.openDrawer(GravityCompat.START)
    }

    private fun setSideMenu() {
        val sideMenuOptionsList =
            listOf(
                SideMenuModel(resources.getDrawable(R.drawable.avatar), "Profile", "Profile"),
                SideMenuModel(resources.getDrawable(R.drawable.list_file), "Appointments", "Appointments"),
                SideMenuModel(resources.getDrawable(R.drawable.list_file), "Doctors", "Doctors"),
                SideMenuModel(resources.getDrawable(R.drawable.list_file), "Nurses", "Nurses"),
                SideMenuModel(resources.getDrawable(R.drawable.list_file), "Orders (Medicines)", "Orders (Medicines)"),
                SideMenuModel(resources.getDrawable(R.drawable.list_file), "Booking ( Equipments)", "Booking ( Equipments)"),
                SideMenuModel(resources.getDrawable(R.drawable.list_file), "Booking (Ambulance)", "Booking (Ambulance)"),
                SideMenuModel(resources.getDrawable(R.drawable.list_file), "Tests ( Labs )", "Tests ( Labs )"),
                SideMenuModel(resources.getDrawable(R.drawable.faq_icon), "Complains", "Settings"),
                SideMenuModel(resources.getDrawable(R.drawable.help), "Help", "Help"),
                SideMenuModel(resources.getDrawable(R.drawable.share_icon), "Share", "Share"),
                SideMenuModel(
                    resources.getDrawable(R.drawable.ic_baseline_settings_24),
                    "Logout",
                    "Logout"
                ),
            )

        sideMenuAdapter = SideMenuAdapter(this, sideMenuOptionsList){
            position, action ->when(action){
            "Profile" -> startActivity(Intent(this,SignupDoctorActivity::class.java))
            "Complains" -> ""
            "Help" -> ""
            "Logout" -> ""
            else -> startActivity(Intent(this,DoctorListActivity::class.java))

        }
        }

        binding.sideLay.sideMenu.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.sideLay.sideMenu.adapter = sideMenuAdapter
    }
}