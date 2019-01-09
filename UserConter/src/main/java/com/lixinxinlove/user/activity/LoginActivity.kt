package com.lixinxinlove.user.activity

import android.net.Uri
import android.os.Bundle
import android.util.Log
import com.alibaba.android.arouter.launcher.ARouter
import com.jaeger.library.StatusBarUtil
import com.kotlin.user.R
import com.lixinxinlove.base.activity.BaseActivity
import com.lixinxinlove.user.data.db.AppDataBaseHelper
import com.lixinxinlove.user.service.UserService
import com.lixinxinlove.user.service.impl.UserServiceImpl
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.SingleOnSubscribe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
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
                .subscribeBy(onNext = {
                    Log.e("登录成功", it.toString())
                    val userInfo = it
                    Single.create(SingleOnSubscribe<Int> {
                        Log.e("Single", "create1")
                        AppDataBaseHelper.getInstance(applicationContext).appDataBase.userInfoDao().insert(userInfo)
                        it.onSuccess(1)
                        Log.e("Single", "create2")
                    }).subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(object : SingleObserver<Int> {
                            override fun onSuccess(t: Int) {
                                ARouter.getInstance().build("/app/home")
                                    .navigation()
                                finish()
                                Log.e("Single", "onSuccess")
                            }

                            override fun onSubscribe(d: Disposable) {
                                Log.e("Single", "onSubscribe")
                            }

                            override fun onError(e: Throwable) {
                                Log.e("Single", "onError")
                            }
                        })
                }, onError = {
                    mProgressLoading.hideLoading()
                    Log.e("网络异常", "onError")
                }, onComplete = {
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



