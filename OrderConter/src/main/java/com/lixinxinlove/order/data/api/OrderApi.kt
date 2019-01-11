package com.lixinxinlove.item.data.api

import com.kotlin.base.data.protocol.BaseResp
import com.lixinxinlove.order.data.protocol.OrderInfo
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST

/**
 * 订单接口
 */
interface OrderApi {

    @FormUrlEncoded
    @Headers("contentType: application/x-www-form-urlencoded")
    @POST("order/createorder")
    fun createOrder(
        @Field("itemId") itemId: Int,
        @Field("promoId") promoId: Int,
        @Field("amount") amount: Int
    ): Observable<BaseResp<OrderInfo>>


//    @Headers("contentType: application/x-www-form-urlencoded")
//    @GET("item/list")
//    fun itemList(): Observable<BaseResp<List<OrderInfo>>>
//
//
//    @Headers("contentType: application/x-www-form-urlencoded")
//    @GET("item/get")
//    fun item(@Query(value = "id") id: Int): Observable<BaseResp<OrderInfo>>


}