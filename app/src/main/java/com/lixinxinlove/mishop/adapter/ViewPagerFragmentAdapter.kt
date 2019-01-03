package com.lixinxinlove.mishop.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class ViewPagerFragmentAdapter(fm: FragmentManager?, mData: List<Fragment>?) : FragmentPagerAdapter(fm) {

    var mData: List<Fragment>? = null

    init {
        this.mData = mData
    }

    override fun getItem(p0: Int): Fragment {
        return mData!![p0]
    }

    override fun getCount(): Int {
        return mData!!.size
    }
}