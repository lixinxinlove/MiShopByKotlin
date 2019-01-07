package com.lixinxinlove.item.data.api

import com.kotlin.base.data.protocol.BaseResp
import com.lixinxinlove.item.data.protocol.ItemInfo
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST

/**
 * 商品接口
 */
interface ItemApi {

    @FormUrlEncoded
    @Headers("contentType: application/x-www-form-urlencoded")
    @POST("item/create")
    fun addItem(
        @Field("title") title: String,
        @Field("description") description: String,
        @Field("price") price: Double,
        @Field("stock") stock: Int,
        @Field("imgUrl") imgUrl: String
    ): Observable<BaseResp<ItemInfo>>

}