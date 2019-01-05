package com.lixinxinlove.base.activity

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * 基类
 */
abstract class BaseActivity : AppCompatActivity() {

    protected lateinit var context: Context
    abstract fun layoutId(): Int
    abstract fun listener()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context=this
        setContentView(layoutId())
        listener()
    }
}