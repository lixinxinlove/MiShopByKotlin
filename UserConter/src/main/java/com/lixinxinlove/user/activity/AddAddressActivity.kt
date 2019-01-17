package com.lixinxinlove.user.activity

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import com.kotlin.user.R
import com.lixinxinlove.base.activity.BaseActivity
import com.lixinxinlove.user.data.protocol.UserAddress
import com.lixinxinlove.user.service.UserService
import com.lixinxinlove.user.service.impl.UserServiceImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_add_address.*

/**
 * 添加用户收货地址
 */
class AddAddressActivity : BaseActivity() {


    lateinit var userService: UserService

    override fun layoutId(): Int {
        return R.layout.activity_add_address
    }

    override fun listener() {

        btnAddAddress.setOnClickListener {
            addUserAddress()
        }


    }

    @SuppressLint("CheckResult")
    private fun addUserAddress() {

        var userAddress = UserAddress(
            0, 1,
            etName.text.toString(),
            etPhone.text.toString(),
            etMobile.text.toString(),
            etProvince.text.toString(),
            etCity.text.toString(),
            etDistrict.text.toString(),
            etAddress.text.toString(),
            etZip.text.toString()
        )


        mProgressLoading.showLoading()
        userService.add(userAddress)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onNext = {
                    if (it > 0) {
                        setResult(Activity.RESULT_OK)
                        finish()
                    } else {
                        Toast.makeText(context, "添加失败", Toast.LENGTH_SHORT).show()
                    }
                },
                onError = {
                    mProgressLoading.hideLoading()
                },
                onComplete = {
                    mProgressLoading.hideLoading()
                })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userService = UserServiceImpl()

    }


}
