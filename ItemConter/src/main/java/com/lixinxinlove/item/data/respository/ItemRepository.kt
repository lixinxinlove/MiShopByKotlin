package com.lixinxinlove.user.data.respository

import com.kotlin.base.data.net.RetrofitFactory
import com.kotlin.base.ext.convert
import com.lixinxinlove.item.data.api.ItemApi
import com.lixinxinlove.item.data.protocol.ItemInfo
import io.reactivex.Observable


class ItemRepository {

    /*
      添加商品
     */
    fun addItem(title: String, description: String, price: Double, stock: Int, imgUrl: String): Observable<ItemInfo> {
        return RetrofitFactory.instance.create(ItemApi::class.java).addItem(title, description, price, stock, imgUrl)
            .convert()
    }


    /**
     * 商品列表
     */
    fun itemList(): Observable<List<ItemInfo>> {
        return RetrofitFactory.instance.create(ItemApi::class.java).itemList().convert()
    }


    /**
     * 商品详情
     */
    fun item(id: Int): Observable<ItemInfo> {
        return RetrofitFactory.instance.create(ItemApi::class.java).item(id).convert()
    }


}