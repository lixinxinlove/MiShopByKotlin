package com.lixinxinlove.item.service.impl

import com.lixinxinlove.item.data.protocol.ItemInfo
import com.lixinxinlove.item.service.ItemService
import com.lixinxinlove.user.data.respository.ItemRepository
import io.reactivex.Observable

/**
 * 商品服务实现
 */
class ItemServiceImpl : ItemService {


    var itemRepository = ItemRepository()

    override fun addItem(
        title: String,
        description: String,
        price: Double,
        stock: Int,
        imgUrl: String
    ): Observable<ItemInfo> {
        return itemRepository.addItem(title, description, price, stock, imgUrl)
    }

    override fun itemList(): Observable<List<ItemInfo>> {
        return itemRepository.itemList()
    }

}