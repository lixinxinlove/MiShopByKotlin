package com.lixinxinlove.user.service

import com.kotlin.base.data.protocol.BaseResp
import com.kotlin.user.data.protocol.UserInfo
import io.reactivex.Observable


/**
 * yong'h
 */
interface UserService {

    //用户登录
    fun login(telphone:String,password:String):Observable<BaseResp<UserInfo>>

}