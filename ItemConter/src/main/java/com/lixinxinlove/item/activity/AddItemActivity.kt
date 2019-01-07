package com.lixinxinlove.item.activity

import android.os.Bundle
import android.util.Log
import com.lixinxinlove.base.activity.BaseActivity
import com.lixinxinlove.item.R
import com.lixinxinlove.item.service.ItemService
import com.lixinxinlove.item.service.impl.ItemServiceImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_add_item.*

/**
 * 添加商品
 */
class AddItemActivity : BaseActivity() {

    private lateinit var itemService: ItemService

    override fun layoutId(): Int {
        return R.layout.activity_add_item
    }

    override fun listener() {

        btnAdd.setOnClickListener {
            itemService.addItem(
                etTitle.text.toString(), etDescription.text.toString(), etPrice.text.toString().toDouble()
                , etStock.text.toString().toInt(), etImgUrl.text.toString()
            ).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                    onNext = {
                        Log.e("lixinxin", "onNext")
                    },
                    onError = {

                    },
                    onComplete = {
                        Log.e("lixinxin", "onComplete")
                    })
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        itemService = ItemServiceImpl()
    }
}
