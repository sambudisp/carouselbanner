package com.sambudisp.carouselbanner

import android.graphics.PointF
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.DisplayMetrics
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.size
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.RecyclerView
import com.sambudisp.carouselbanner.item.BannerCarouselItem
import com.sambudisp.carouselbanner.item.BannerListener
import com.sambudisp.carouselbanner.model.BannerPromo
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import java.util.*

class MainActivity : AppCompatActivity(), BannerListener {

    private var rvMain: RecyclerView? = null
    private val handler = Handler()
    private lateinit var SCROLLING_RUNNABLE: Runnable
    private lateinit var llayoutManager: LinearLayoutManager
    private var count = 0

    private var lastPosition : Int? = null

    private var groupAdapter = GroupAdapter<ViewHolder>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        llayoutManager = LinearLayoutManager(this)
        rvMain = findViewById(R.id.rvUtama)

        val promos = listOf(
                BannerPromo(
                        name = "Puncak badai uang",
                        image = "https://s2.bukalapak.com/uploads/promo_partnerinfo_bloggy/2842/Bloggy_1_puncak.jpg"),
                BannerPromo(
                        name = "hati hati ada guncangan badai uang",
                        image = "https://sphensensander.files.wordpress.com/2016/08/img_20160725_162431.jpg?w=700"),
                BannerPromo(
                        name = "Puncak badai uang",
                        image = "https://s2.bukalapak.com/uploads/promo_partnerinfo_bloggy/2842/Bloggy_1_puncak.jpg"),
                BannerPromo(
                        name = "hati hati ada guncangan badai uang",
                        image = "https://sphensensander.files.wordpress.com/2016/08/img_20160725_162431.jpg?w=700"),
                BannerPromo(
                        name = "Puncak badai uang",
                        image = "https://s2.bukalapak.com/uploads/promo_partnerinfo_bloggy/2842/Bloggy_1_puncak.jpg"),
                BannerPromo(
                        name = "hati hati ada guncangan badai uang",
                        image = "https://sphensensander.files.wordpress.com/2016/08/img_20160725_162431.jpg?w=700")
        )

        rvMain?.apply {
            layoutManager = llayoutManager
            adapter = groupAdapter
        }

        val bannerCarouselItem = BannerCarouselItem(promos, supportFragmentManager, this)
        groupAdapter.add(bannerCarouselItem)

        val runnable = object : Runnable{
            override fun run() {
                if (count < promos.size){
                    recylerViewSmoothScroll(count)
                    Log.d("Countnya", "${count} | ${promos.size}" )
                    handler.postDelayed(this, 1000)
                    count = count.plus(1)
                }
            }
        }
        handler.postDelayed(runnable, 1000)
    }

    private fun recylerViewSmoothScroll(position: Int) {
        val smoothScroll: RecyclerView.SmoothScroller = object : LinearSmoothScroller(this) {
            override fun getHorizontalSnapPreference(): Int {
                return super.getHorizontalSnapPreference()
            }

            override fun computeScrollVectorForPosition(targetPosition: Int): PointF? {
                return super.computeScrollVectorForPosition(targetPosition)
            }

            override fun calculateSpeedPerPixel(displayMetrics: DisplayMetrics?): Float {
                return 50F / displayMetrics!!.densityDpi
            }
        }

        smoothScroll.targetPosition = position
        rvMain?.apply {
            layoutManager?.startSmoothScroll(smoothScroll)
        }
    }


    override fun onSeeAllPromoClick() {
    }

    override fun onBannerClick(promo: BannerPromo) {
    }

}