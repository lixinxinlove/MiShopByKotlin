package com.lixinxinlove.user.service

import com.lixinxinlove.order.data.protocol.OrderInfo
import io.reactivex.Observable


/**
 * 订单
 */
interface OrderService {

    //用户登录
    fun createOrder(itemId: Int, promoId: Int, amount: Int): Observable<OrderInfo>

}