package com.lixinxinlove.mishop.activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.room.Room
import androidx.viewpager.widget.ViewPager
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kotlin.base.common.AppManager
import com.kotlin.user.data.protocol.UserInfo
import com.lixinxinlove.base.activity.BaseActivity
import com.lixinxinlove.item.fragment.ItemFragment
import com.lixinxinlove.mishop.R
import com.lixinxinlove.mishop.adapter.ViewPagerFragmentAdapter
import com.lixinxinlove.order.fragment.OrderFragment
import com.lixinxinlove.user.data.db.AppDatabase
import com.lixinxinlove.user.fragment.MyselFragment
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.SingleOnSubscribe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_home.*


@Route(path = "/app/home")
class HomeActivity : BaseActivity(), ViewPager.OnPageChangeListener {

    private var db:AppDatabase? = null

    override fun layoutId(): Int {
        return R.layout.activity_home
    }


    var mData: List<Fragment>? = null
    var adapter: ViewPagerFragmentAdapter? = null

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                homeViewPager.currentItem = 0
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_myself -> {
                homeViewPager.currentItem = 1
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                homeViewPager.currentItem = 2
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mData = arrayListOf(ItemFragment(), OrderFragment(), MyselFragment())

        adapter = ViewPagerFragmentAdapter(supportFragmentManager, mData)

        homeViewPager.adapter = adapter

        db=  Room.databaseBuilder(applicationContext, AppDatabase::class.java, "mishop").fallbackToDestructiveMigration().build()

        Single.create(SingleOnSubscribe<Int> {
            Log.e("Single", "create1")
            val userInfo= UserInfo(1,"1111",1,1,"123456789")
            db!!.userInfoDao().insert(userInfo)
           // AppDatabase.getInstance(applicationContext).userInfoDao().insert(userInfo)
            it.onSuccess(1)
            Log.e("Single", "create2")
        }).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<Int> {
                override fun onSuccess(t: Int) {
                    Log.e("Single", "onSuccess")
                }

                override fun onSubscribe(d: Disposable) {
                    Log.e("Single", "onSubscribe")
                }

                override fun onError(e: Throwable) {
                    Log.e("Single", "onError")
                }
            })


    }


    override fun listener() {

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        homeViewPager.addOnPageChangeListener(this)
    }


    override fun onPageScrollStateChanged(postion: Int) {
    }

    override fun onPageScrolled(postion: Int, p1: Float, p2: Int) {
    }

    override fun onPageSelected(postion: Int) {
        when (postion) {
            0 -> {
                navigation.selectedItemId = R.id.navigation_home
            }
            1 -> {
                navigation.selectedItemId = R.id.navigation_myself
            }
            2 -> {
                navigation.selectedItemId = R.id.navigation_notifications
            }
        }

    }


    internal var exitTime: Long = 0

    //返回键监听
    override fun onBackPressed() {
        if (System.currentTimeMillis() - exitTime > 2000) {
            Toast.makeText(this, "再按一次退应用", Toast.LENGTH_SHORT).show()
            exitTime = System.currentTimeMillis()
        } else {
            AppManager.instance.exitApp(context)
        }
    }

}
