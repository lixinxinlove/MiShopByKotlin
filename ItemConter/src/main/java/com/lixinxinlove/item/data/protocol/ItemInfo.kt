package com.lixinxinlove.item.data.protocol

data class ItemInfo(
    val id:Int,
    val title: String,
    val description: String,
    val price: Double,
    val stock: Int,
    val imgUrl: String
){
    override fun toString(): String {
        return "ItemInfo(id=$id, title='$title', description='$description', price=$price, stock=$stock, imgUrl='$imgUrl')"
    }
}