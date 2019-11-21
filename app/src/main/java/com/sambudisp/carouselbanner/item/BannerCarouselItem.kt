package com.sambudisp.carouselbanner.item

import androidx.fragment.app.FragmentManager
import com.sambudisp.carouselbanner.R
import com.sambudisp.carouselbanner.adapter.BannerAdapter
import com.sambudisp.carouselbanner.model.BannerPromo
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_carousel_banner.view.*

interface BannerListener{
    fun onSeeAllPromoClick()
    fun onBannerClick(promo : BannerPromo)
}

class BannerCarouselItem (
    private val banners: List<BannerPromo>,
    private val supportFragmentManager: FragmentManager,
    private val listener: BannerListener) : Item() {

    override fun bind(viewHolder: ViewHolder, position: Int) {
        val viewPagerAdapter = BannerAdapter(supportFragmentManager, banners)

        viewHolder.itemView.viewPagerBanner.adapter = viewPagerAdapter
        viewHolder.itemView.indicator.setViewPager(viewHolder.itemView.viewPagerBanner)
    }

    override fun getLayout(): Int = R.layout.item_carousel_banner

}