package com.lixinxinlove.user.activity

import android.net.Uri
import android.os.Bundle
import android.util.Log
import com.alibaba.android.arouter.launcher.ARouter
import com.jaeger.library.StatusBarUtil
import com.kotlin.user.R
import com.lixinxinlove.base.activity.BaseActivity
import com.lixinxinlove.user.service.UserService
import com.lixinxinlove.user.service.impl.UserServiceImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {


    private lateinit var userService: UserService

    override fun layoutId(): Int {
        return R.layout.activity_login
    }

    override fun listener() {
        btnLogin.setOnClickListener {
            mProgressLoading.showLoading()
            userService.login(etPhone.text.toString(), etPassword.text.toString())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                    onNext = {
                        Log.e("登录成功", it.name)
                        ARouter.getInstance().build("/app/home").navigation()
                        finish()
                    },
                    onError = {
                        mProgressLoading.hideLoading()
                        Log.e("网络异常", "onError")
                    },
                    onComplete = {
                        mProgressLoading.hideLoading()
                    })
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        StatusBarUtil.setDarkMode(this)
        StatusBarUtil.setTransparent(this)
        super.onCreate(savedInstanceState)
        var uri = "android.resource://" + packageName + "/" + R.raw.login
        vvLogin.requestFocus()
        vvLogin.setOnCompletionListener { vvLogin.start() }
        vvLogin.setVideoURI(Uri.parse(uri))
        vvLogin.start()
        userService = UserServiceImpl()
    }
}


