package com.lixinxinlove.mishop.activity

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.alibaba.android.arouter.facade.annotation.Route
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kotlin.base.common.AppManager
import com.lixinxinlove.base.activity.BaseActivity
import com.lixinxinlove.item.fragment.ItemFragment
import com.lixinxinlove.mishop.R
import com.lixinxinlove.mishop.adapter.ViewPagerFragmentAdapter
import com.lixinxinlove.order.fragment.OrderFragment
import com.lixinxinlove.user.fragment.MyselFragment
import kotlinx.android.synthetic.main.activity_home.*


@Route(path = "/app/home")
class HomeActivity : BaseActivity(), ViewPager.OnPageChangeListener {

    override fun layoutId(): Int {
        return R.layout.activity_home
    }


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

        mData = arrayListOf(ItemFragment(), OrderFragment(), MyselFragment())

        adapter = ViewPagerFragmentAdapter(supportFragmentManager, mData)

        homeViewPager.adapter = adapter
    }


    override fun listener() {

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


    internal var exitTime: Long = 0

    //返回键监听
    override fun onBackPressed() {
        if (System.currentTimeMillis() - exitTime > 2000) {
            Toast.makeText(this, "再按一次退应用", Toast.LENGTH_SHORT).show()
            exitTime = System.currentTimeMillis()
        } else {
            AppManager.instance.exitApp(context)
        }
    }

}
