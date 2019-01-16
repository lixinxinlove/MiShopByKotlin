package com.lixinxinlove.user.activity

import android.annotation.SuppressLint
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

    lateinit var userService:UserService

    override fun layoutId(): Int {
        return R.layout.activity_user_address_manage
    }

    override fun listener() {

    }

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mRecyclerView.layoutManager = LinearLayoutManager(context)
        mAdapter = UserAddressAdapter(mData)
        mRecyclerView.adapter = mAdapter

        userService = UserServiceImpl()
        mProgressLoading.showLoading()
        userService.addressList(1)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onNext = {
                    Log.e("UserAddressManage", "onNext")
                    mAdapter!!.setNewData(it)
                },
                onError = {
                    Log.e("UserAddressManage", "onError")
                    mProgressLoading.hideLoading()
                },
                onComplete = {
                    mProgressLoading.hideLoading()
                    Log.e("UserAddressManage", "onComplete")
                })

    }
}
