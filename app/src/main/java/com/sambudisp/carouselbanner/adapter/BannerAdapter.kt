package com.sambudisp.carouselbanner.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.sambudisp.carouselbanner.BannerFragment
import com.sambudisp.carouselbanner.model.BannerPromo

class BannerAdapter (
    fragmentManager : FragmentManager,
    private val banners : List<BannerPromo>) : FragmentPagerAdapter(fragmentManager){

    override fun getItem(position: Int): Fragment {
        return BannerFragment.newInstance(banners[position].image)
    }

    override fun getCount(): Int = banners.size

}