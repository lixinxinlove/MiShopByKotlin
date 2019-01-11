package com.lixinxinlove.user.data.respository

import com.kotlin.base.data.net.RetrofitFactory
import com.kotlin.base.ext.convert
import com.lixinxinlove.item.data.api.OrderApi
import com.lixinxinlove.order.data.protocol.OrderInfo
import io.reactivex.Observable

class OrderRepository {

    /*
      添加商品
     */
    fun createOrder(itemId: Int, promoId: Int, amount: Int): Observable<OrderInfo> {
        return RetrofitFactory.instance.create(OrderApi::class.java).createOrder(itemId, promoId, amount)
            .convert()
    }


//    /**
//     * 商品列表
//     */
//    fun itemList(): Observable<List<OrderInfo>> {
//        return RetrofitFactory.instance.create(OrderApi::class.java).itemList().convert()
//    }
//
//
//    /**
//     * 商品详情
//     */
//    fun item(id: Int): Observable<OrderInfo> {
//        return RetrofitFactory.instance.create(OrderApi::class.java).item(id).convert()
//    }


}