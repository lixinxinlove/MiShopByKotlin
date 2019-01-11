package com.lixinxinlove.user.service.impl

import com.lixinxinlove.order.data.protocol.OrderInfo
import com.lixinxinlove.user.data.respository.OrderRepository
import com.lixinxinlove.user.service.OrderService
import io.reactivex.Observable

/**
 * 订单相关
 */
class OrderServiceImpl : OrderService {

    private var orderRepository = OrderRepository()

    override fun createOrder(itemId: Int, promoId: Int, amount: Int): Observable<OrderInfo> {
        return orderRepository.createOrder(itemId, promoId, amount)
    }

}