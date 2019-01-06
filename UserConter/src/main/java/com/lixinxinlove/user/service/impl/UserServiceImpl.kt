package com.lixinxinlove.user.service.impl

import com.kotlin.base.data.protocol.BaseResp
import com.kotlin.base.ext.convert
import com.kotlin.base.ext.convertBoolean
import com.kotlin.user.data.protocol.UserInfo
import com.lixinxinlove.user.data.respository.UserRepository
import com.lixinxinlove.user.service.UserService
import io.reactivex.Observable


class UserServiceImpl : UserService {

    private var userRepository = UserRepository()

    override fun login(telphone: String, password: String): Observable<BaseResp<UserInfo>> {
        return userRepository.login(telphone, password)
    }

}