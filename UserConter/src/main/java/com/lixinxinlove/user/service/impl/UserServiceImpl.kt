package com.lixinxinlove.user.service.impl

import com.kotlin.user.data.protocol.UserInfo
import com.lixinxinlove.user.data.protocol.UserAddress
import com.lixinxinlove.user.data.respository.UserRepository
import com.lixinxinlove.user.service.UserService
import io.reactivex.Observable


class UserServiceImpl : UserService {


    private var userRepository = UserRepository()

    override fun login(telphone: String, password: String): Observable<UserInfo> {
        return userRepository.login(telphone, password)
    }

    override fun addressList(userId: Int): Observable<List<UserAddress>> {
        return userRepository.addressList(userId)
    }

}