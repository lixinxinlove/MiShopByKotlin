package com.lixinxinlove.user.service

import com.kotlin.user.data.protocol.UserInfo
import com.lixinxinlove.user.data.protocol.UserAddress
import io.reactivex.Observable


/**
 * yong'h
 */
interface UserService {

    //用户登录
    fun login(telphone: String, password: String): Observable<UserInfo>

    fun addressList(userId: Int): Observable<List<UserAddress>>

    fun add(userAddress: UserAddress): Observable<Int>

}