package com.lixinxinlove.base.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * 基类
 */
abstract class BaseActivity : AppCompatActivity() {

    abstract fun layoutId(): Int
    abstract fun listener()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId())
        listener()
    }
}