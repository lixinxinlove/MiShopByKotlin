package com.lixinxinlove.user.data.api

import com.kotlin.base.data.protocol.BaseResp
import com.kotlin.user.data.protocol.*
import io.reactivex.Observable
import retrofit2.http.*


/**
 * 用户模块api 接口
 */
interface UserApi {

    /*
        用户登录
     */
    @FormUrlEncoded
    @Headers("contentType: application/x-www-form-urlencoded")
    @POST("user/login")
   // fun login(@Body req: LoginReq):Observable<BaseResp<UserInfo>>
    fun login(@Field( "telphone") telphone:String, @Field( "password") password:String):Observable<BaseResp<UserInfo>>


}