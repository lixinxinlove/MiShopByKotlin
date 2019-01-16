package com.lixinxinlove.user.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.kotlin.user.R
import com.lixinxinlove.user.data.protocol.UserAddress

/**
 * 用户收获地址
 */
class UserAddressAdapter(data: MutableList<UserAddress>?) :
    BaseQuickAdapter<UserAddress, BaseViewHolder>(R.layout.item_address_list, data) {

    override fun convert(helper: BaseViewHolder?, item: UserAddress?) {
        helper!!.setText(R.id.tv_name, item!!.receiverName)
        helper!!.setText(R.id.tv_phone, item!!.receiverPhone)
        helper!!.setText(R.id.tv_address, item!!.receiverAddress)
    }

}