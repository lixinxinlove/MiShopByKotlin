package com.lixinxinlove.item.data.api

import com.kotlin.base.data.protocol.BaseResp
import com.lixinxinlove.item.data.protocol.ItemInfo
import io.reactivex.Observable
import retrofit2.http.*

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




    @Headers("contentType: application/x-www-form-urlencoded")
    @GET("item/list")
    fun itemList(): Observable<BaseResp<List<ItemInfo>>>


}