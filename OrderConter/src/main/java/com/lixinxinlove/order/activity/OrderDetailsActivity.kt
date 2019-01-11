package com.lixinxinlove.order.activity

import android.os.Bundle
import android.util.Log
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.lixinxinlove.base.activity.BaseActivity
import com.lixinxinlove.order.R
import com.lixinxinlove.user.service.OrderService
import com.lixinxinlove.user.service.impl.OrderServiceImpl


/**
 * 订单详情
 */
@Route(path = "/order/details")
class OrderDetailsActivity : BaseActivity() {

     var id: Int=-1

    lateinit var orderService: OrderService

    override fun layoutId(): Int {
        return R.layout.activity_order_details
    }

    override fun listener() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ARouter.getInstance().inject(this)

        id= intent.getIntExtra("id",0)
        Log.e("OrderDetailsActivity", " itemId= $id ")

        orderService = OrderServiceImpl()
    }
}
