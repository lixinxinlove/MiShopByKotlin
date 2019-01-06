package com.lixinxinlove.user.activity

import android.net.Uri
import android.os.Bundle
import android.util.Log
import com.jaeger.library.StatusBarUtil
import com.kotlin.base.data.net.RetrofitFactory
import com.kotlin.base.data.protocol.BaseResp
import com.kotlin.user.R
import com.kotlin.user.data.protocol.UserInfo
import com.lixinxinlove.base.activity.BaseActivity
import com.lixinxinlove.user.data.api.UserApi
import com.lixinxinlove.user.service.UserService
import com.lixinxinlove.user.service.impl.UserServiceImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {


    private lateinit var userService: UserService


    override fun layoutId(): Int {
        return R.layout.activity_login
    }

    override fun listener() {

        btnLogin.setOnClickListener {

            RetrofitFactory.instance.create(UserApi::class.java).login("17090408824","123456")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Consumer<BaseResp<UserInfo>> {
                    override fun accept(t: BaseResp<UserInfo>?) {
                        Log.e("lixinxin",t!!.data!!.name)
                    }
                })


//            userService.login(etPhone.text.toString(), etPassword.text.toString())
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(object : Consumer<BaseResp<UserInfo>> {
//                    override fun accept(t: BaseResp<UserInfo>?) {
//                        Log.e("lixinxin",t!!.data!!.name)
//                    }
//                })
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

