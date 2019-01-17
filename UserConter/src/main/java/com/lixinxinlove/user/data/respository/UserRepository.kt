package com.lixinxinlove.user.data.respository

import com.kotlin.base.data.net.RetrofitFactory
import com.kotlin.base.ext.convert
import com.kotlin.user.data.protocol.UserInfo
import com.lixinxinlove.user.data.api.UserApi
import com.lixinxinlove.user.data.protocol.UserAddress
import io.reactivex.Observable


class UserRepository {

    /*
        用户登录
     */
    fun login(telphone: String, password: String): Observable<UserInfo> {
        return RetrofitFactory.instance.create(UserApi::class.java).login(telphone, password).convert()
    }

    /**
     * 地址列表
     */
    fun addressList(userId: Int): Observable<List<UserAddress>> {
        return RetrofitFactory.instance.create(UserApi::class.java).addressList(userId).convert()
    }

    fun add(userAddress: UserAddress): Observable<Int> {
        return RetrofitFactory.instance.create(UserApi::class.java).add(userAddress).convert()
    }


}