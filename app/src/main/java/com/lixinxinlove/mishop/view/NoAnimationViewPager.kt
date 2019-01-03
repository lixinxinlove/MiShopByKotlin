package com.lixinxinlove.mishop.view

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet

/**
 * 去掉动画
 */
class NoAnimationViewPager : ViewPager {

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    override fun setCurrentItem(item: Int) {
        super.setCurrentItem(item, false)
    }

}