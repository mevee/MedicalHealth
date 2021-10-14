//package com.heathcareinhand.ui.intro
//
//import android.content.Context
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.core.content.ContextCompat.getSystemService
//import androidx.recyclerview.widget.RecyclerView
//import androidx.viewpager.widget.PagerAdapter
//import coil.load
//import com.heathcareinhand.databinding.IntroItemBinding
//
//
//class IntroPageAdapter(val context: Context, val introDataList: List<IntroModel>) :
//    PagerAdapter() {
//    private lateinit var layoutInflater: LayoutInflater
//    init {
//
//    }
//
//    override fun getCount() = introDataList.size
//
//    override fun isViewFromObject(view: View, `object`: Any): Boolean {
//        return view === `object`
//    }
//
//    override fun instantiateItem(container: ViewGroup, position: Int): Any {
//        layoutInflater = LayoutInflater.from(context)
//
//        // Inflate the layout for the page
//        val bind: IntroItemBinding =
//            IntroItemBinding.inflate(layoutInflater, container, false)
//        val data = introDataList[position]
//        bind.ivIntro.load(data.image)
//        bind.tvMessageIntro.text = "${data.image}"
//
//        return bind.root
//    }
//
//}