package com.lixinxinlove.mishop

import android.util.Log
import com.kotlin.user.data.protocol.UserInfo
import com.lixinxinlove.base.common.BaseApplication
import com.lixinxinlove.user.data.db.UserDataBaseHelper
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Application 入口
 */
class App : BaseApplication() {

    companion object {
        var isLogin = false
        var user: UserInfo? = null
    }

    override fun onCreate() {
        super.onCreate()
        getUser()
    }

    private fun getUser() {
        UserDataBaseHelper.getInstance(applicationContext).appDataBase.userInfoDao().getUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<List<UserInfo>> {
                override fun onSuccess(t: List<UserInfo>) {
                    user = t[0]
                    isLogin = true
                    Log.e("App",user.toString())
                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onError(e: Throwable) {
                    isLogin = false
                }
            })
    }

}
