package com.lixinxinlove.mishop.activity

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.lixinxinlove.mishop.R
import com.lixinxinlove.mishop.adapter.ViewPagerFragmentAdapter
import com.lixinxinlove.mishop.fragment.HomeFragment
import com.lixinxinlove.mishop.fragment.MyselfFragment
import com.lixinxinlove.mishop.fragment.NotificationsFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), ViewPager.OnPageChangeListener {


    var mData: List<Fragment>? = null
    var adapter: ViewPagerFragmentAdapter? = null

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                homeViewPager.currentItem = 0
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_myself -> {
                homeViewPager.currentItem = 1
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                homeViewPager.currentItem = 2
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        mData = arrayListOf(HomeFragment(), MyselfFragment(), NotificationsFragment())

        adapter = ViewPagerFragmentAdapter(supportFragmentManager, mData)

        homeViewPager.adapter = adapter

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        homeViewPager.addOnPageChangeListener(this)
    }

    override fun onPageScrollStateChanged(postion: Int) {
    }

    override fun onPageScrolled(postion: Int, p1: Float, p2: Int) {
    }

    override fun onPageSelected(postion: Int) {
        when (postion) {
            0 -> {
                navigation.selectedItemId = R.id.navigation_home
            }
            1 -> {
                navigation.selectedItemId = R.id.navigation_myself
            }
            2 -> {
                navigation.selectedItemId = R.id.navigation_notifications
            }
        }

    }

}
