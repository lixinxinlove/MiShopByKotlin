package com.lixinxinlove.mishop.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerFragmentAdapter(fm: FragmentManager, mData: List<Fragment>?) : FragmentPagerAdapter(fm) {

    var mData: List<androidx.fragment.app.Fragment>? = null

    init {
        this.mData = mData
    }

    override fun getItem(p0: Int): androidx.fragment.app.Fragment {
        return mData!![p0]
    }

    override fun getCount(): Int {
        return mData!!.size
    }
}