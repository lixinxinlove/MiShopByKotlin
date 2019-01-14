package com.lixinxinlove.item.fragment


import android.annotation.SuppressLint
import android.content.Intent
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.lixinxinlove.base.fragment.BaseFragment
import com.lixinxinlove.item.R
import com.lixinxinlove.item.activity.ItemDetailsActivity
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
class ItemFragment : BaseFragment(), BaseQuickAdapter.OnItemClickListener {

    private lateinit var itemService: ItemService

    private lateinit var rvItemList: RecyclerView

    private lateinit var mAdapter: ItemListAdapter

    private var mData: List<ItemInfo>? = listOf()

    override fun layoutId(): Int {
        return R.layout.fragment_item
    }
    override fun findView() {
    }
    override fun listener() {
        mAdapter.setOnItemClickListener(this)
    }


    @SuppressLint("CheckResult")
    override fun _onCreateView() {


        rvItemList = rootView.findViewById(R.id.rvItemList)
        rvItemList.layoutManager = LinearLayoutManager(context)

        mAdapter = ItemListAdapter(mData!!)


        rvItemList.adapter = mAdapter

        itemService = ItemServiceImpl()
        mProgressLoading.showLoading()
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
                    mProgressLoading.hideLoading()
                },
                onComplete = {
                    mProgressLoading.hideLoading()
                    Log.e("ItemFragment", "onComplete")
                })
    }


    override fun onItemClick(adapter: BaseQuickAdapter<*, *>?, view: View?, position: Int) {
        val intent=Intent(context,ItemDetailsActivity::class.java)
        intent!!.putExtra("id",mAdapter.data[position].id)
        startActivity(intent)
    }

}


