package com.lixinxinlove.mishop.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

open abstract class BaseFragment : Fragment() {

    var rootView: View? = null

    abstract fun getLayoutId(): Int
    abstract fun setListener()
    abstract fun _onCreateView()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        rootView = View.inflate(layoutInflater.context, getLayoutId(), null)
        setListener()
        _onCreateView()
        return rootView
    }


}