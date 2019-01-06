package com.lixinxinlove.base.activity

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kotlin.base.common.AppManager

/**
 * 基类
 */
abstract class BaseActivity : AppCompatActivity() {

    protected lateinit var context: Context
    abstract fun layoutId(): Int
    abstract fun listener()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppManager.instance.addActivity(this)
        context=this
        setContentView(layoutId())
        listener()
    }

    override fun onDestroy() {
        super.onDestroy()
        AppManager.instance.finishActivity(this)
    }


}