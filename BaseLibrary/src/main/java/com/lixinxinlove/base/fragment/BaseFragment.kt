package com.lixinxinlove.base.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * 基类
 */
abstract class BaseFragment : Fragment() {

    lateinit var rootView: View

    abstract fun layoutId(): Int
    abstract fun listener()
    abstract fun _onCreateView()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(layoutId(), container, false)
        _onCreateView()
        listener()
        return rootView
    }


}