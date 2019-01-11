package com.lixinxinlove.item.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import com.alibaba.android.arouter.launcher.ARouter
import com.jaeger.library.StatusBarUtil
import com.kotlin.base.utils.GlideUtils
import com.lixinxinlove.base.activity.BaseActivity
import com.lixinxinlove.item.R
import com.lixinxinlove.item.service.ItemService
import com.lixinxinlove.item.service.impl.ItemServiceImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_item_details.*

/**
 * 商品详情
 */
class ItemDetailsActivity : BaseActivity() {

    var id: Int = 0

    private lateinit var itemService: ItemService

    override fun layoutId(): Int {
        return R.layout.activity_item_details
    }

    override fun listener() {

        btnBuy.setOnClickListener {
            ARouter.getInstance().build("/order/details").withInt("id", id).navigation()
        }

    }

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        StatusBarUtil.setLightMode(this)
        StatusBarUtil.setTransparent(this)
        super.onCreate(savedInstanceState)
        id = intent.getIntExtra("id", 0)
        itemService = ItemServiceImpl()
        mProgressLoading.showLoading()
        itemService.item(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onNext = {
                    Log.e("ItemDetailsActivity", "onNext")
                    GlideUtils.loadImage(context, it.imgUrl, ivItemImage)
                    tvTitle.text = it.title
                    tvDescription.text = it.description
                    tvPrice.text = it.price.toString()
                },
                onError = {
                    Log.e("ItemDetailsActivity", "onError")
                    mProgressLoading.hideLoading()
                },
                onComplete = {
                    mProgressLoading.hideLoading()
                    Log.e("ItemDetailsActivity", "onComplete")
                })
    }
}
