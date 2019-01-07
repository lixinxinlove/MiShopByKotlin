package com.lixinxinlove.item.fragment


import android.annotation.SuppressLint
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lixinxinlove.base.fragment.BaseFragment
import com.lixinxinlove.item.R
import com.lixinxinlove.item.adapter.ItemListAdapter
import com.lixinxinlove.item.data.protocol.ItemInfo
import com.lixinxinlove.item.service.ItemService
import com.lixinxinlove.item.service.impl.ItemServiceImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers


/**
 * 首页商品列表
 */
class ItemFragment : BaseFragment() {

    private lateinit var itemService: ItemService

    private lateinit var rvItemList: RecyclerView

    private var mData: List<ItemInfo>? = listOf()

    override fun layoutId(): Int {
        return R.layout.fragment_item
    }

    override fun listener() {
    }


    @SuppressLint("CheckResult")
    override fun _onCreateView() {


        rvItemList = rootView.findViewById(R.id.rvItemList)
        rvItemList.layoutManager = LinearLayoutManager(context)

        var mAdapter = ItemListAdapter(mData!!)
        rvItemList.adapter = mAdapter

        itemService = ItemServiceImpl()
        itemService.itemList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onNext = {
                    Log.e("ItemFragment", "onNext")
                    mAdapter.setNewData(it)
                },
                onError = {
                    Log.e("ItemFragment", "onError")
                },
                onComplete = {

                    Log.e("ItemFragment", "onComplete")
                })


    }
}


