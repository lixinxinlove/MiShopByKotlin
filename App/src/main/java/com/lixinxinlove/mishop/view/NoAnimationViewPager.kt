package com.lixinxinlove.mishop.view

import android.content.Context
import androidx.viewpager.widget.ViewPager
import android.util.AttributeSet

/**
 * 去掉动画
 */
class NoAnimationViewPager : androidx.viewpager.widget.ViewPager {

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    override fun setCurrentItem(item: Int) {
        super.setCurrentItem(item, false)
    }

}