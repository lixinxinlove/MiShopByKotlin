package com.lixinxinlove.base.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

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