package com.lixinxinlove.item.adapter

import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.kotlin.base.utils.GlideUtils
import com.lixinxinlove.item.R
import com.lixinxinlove.item.data.protocol.ItemInfo

/**
 *  商品列表
 *
 */
class ItemListAdapter(data: List<ItemInfo>) :
    BaseQuickAdapter<ItemInfo, BaseViewHolder>(R.layout.item_item_list, data) {

    override fun convert(helper: BaseViewHolder, item: ItemInfo) {
        GlideUtils.loadImage(mContext, item.imgUrl, helper.getView(R.id.ivImage) as ImageView)
        helper.setText(R.id.tvTitle, item.title)
    }
}
