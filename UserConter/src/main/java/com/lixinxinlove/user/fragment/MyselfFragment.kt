package com.lixinxinlove.user.fragment

import android.util.Log
import com.kotlin.user.R
import com.kotlin.user.data.protocol.UserInfo
import com.lixinxinlove.base.fragment.BaseFragment
import com.lixinxinlove.user.data.db.UserDataBaseHelper
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_myself.*

/**
 * 个人中心
 */
class MyselfFragment : BaseFragment() {


    private lateinit var user: UserInfo

    override fun layoutId(): Int {
        return R.layout.fragment_myself
    }

    override fun listener() {
    }

    override fun _onCreateView() {
        getUser()
    }


    private fun getUser() {
        mProgressLoading.showLoading()
        UserDataBaseHelper.getInstance(mContext).appDataBase.userInfoDao().getUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<List<UserInfo>> {
                override fun onSuccess(t: List<UserInfo>) {
                    mProgressLoading.hideLoading()
                    user = t[0]
                    setUpView()
                    Log.e("MyselfFragment", user.toString())
                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onError(e: Throwable) {
                    mProgressLoading.hideLoading()
                }
            })
    }


    private fun setUpView() {
        if (user != null) {
            tvUser.text = user.name
            tvPhone.text = user.telphone
            tvAge.text = user.age.toString()
            if (user.gender!!.toInt() == 1) {
                tvSex.text = "男"
            } else {
                tvSex.text = "女"
            }
        }
    }

}