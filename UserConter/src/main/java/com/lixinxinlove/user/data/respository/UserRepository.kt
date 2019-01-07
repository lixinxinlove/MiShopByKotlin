package com.lixinxinlove.user.data.respository

import com.kotlin.base.data.net.RetrofitFactory
import com.kotlin.base.ext.convert
import com.kotlin.user.data.protocol.UserInfo
import com.lixinxinlove.user.data.api.UserApi
import io.reactivex.Observable


class UserRepository{

    /*
        用户登录
     */
    fun login(telphone:String,password:String): Observable<UserInfo>{
        return RetrofitFactory.instance.create(UserApi::class.java).login(telphone,password).convert()
    }


}