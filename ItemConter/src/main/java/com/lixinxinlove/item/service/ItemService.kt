package com.lixinxinlove.item.service

import com.lixinxinlove.item.data.protocol.ItemInfo
import io.reactivex.Observable

/**
 * 商品服务
 */
interface ItemService {
    fun addItem(title: String, description: String, price: Double, stock: Int, imgUrl: String): Observable<ItemInfo>

    fun itemList(): Observable<List<ItemInfo>>

    fun item(id: Int): Observable<ItemInfo>
}