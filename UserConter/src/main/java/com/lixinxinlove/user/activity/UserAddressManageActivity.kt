package com.lixinxinlove.user.activity

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.kotlin.user.R
import com.lixinxinlove.base.activity.BaseActivity
import com.lixinxinlove.user.adapter.UserAddressAdapter
import com.lixinxinlove.user.data.protocol.UserAddress
import com.lixinxinlove.user.service.UserService
import com.lixinxinlove.user.service.impl.UserServiceImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_user_address_manage.*

/**
 * 收获地址
 */
class UserAddressManageActivity : BaseActivity() {

    var mData: MutableList<UserAddress>? = null

    var mAdapter: UserAddressAdapter? = null


    lateinit var userService: UserService

    override fun layoutId(): Int {
        return R.layout.activity_user_address_manage
    }

    override fun listener() {
        mSwipeRefreshLayout.setOnRefreshListener {
            getData()
        }

        btnAdd.setOnClickListener {
            startActivityForResult(Intent(context, AddAddressActivity::class.java), 100)
        }

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode != Activity.RESULT_OK) {
            return
        }
        when (requestCode) {
            100 -> {
                getData()
            }
        }
    }


    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mRecyclerView.layoutManager = LinearLayoutManager(context)
        mAdapter = UserAddressAdapter(mData)
        mRecyclerView.adapter = mAdapter

        userService = UserServiceImpl()
        // mProgressLoading.showLoading()
        getData()
    }


    @SuppressLint("CheckResult")
    private fun getData() {
        mSwipeRefreshLayout.isRefreshing = true
        userService.addressList(1)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onNext = {
                    Log.e("UserAddressManage", "onNext")
                    mAdapter!!.setNewData(it)
                    Log.e("onNext", "${it.size}")
                },
                onError = {
                    Log.e("UserAddressManage", "onError")
                    mProgressLoading.hideLoading()
                    mSwipeRefreshLayout.isRefreshing = false
                },
                onComplete = {
                    mProgressLoading.hideLoading()
                    mSwipeRefreshLayout.isRefreshing = false
                    Log.e("UserAddressManage", "onComplete")
                })

    }
}
