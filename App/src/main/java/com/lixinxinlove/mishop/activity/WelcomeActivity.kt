package com.lixinxinlove.mishop.activity


import android.content.Intent
import android.os.Bundle
import com.lixinxinlove.base.activity.BaseActivity
import com.lixinxinlove.mishop.R
import com.lixinxinlove.user.activity.LoginActivity
import kotlinx.android.synthetic.main.activity_welcome.*
import android.R.raw


/**
 * 欢迎页
 */
class WelcomeActivity : BaseActivity() {

    override fun layoutId(): Int {
        return R.layout.activity_welcome
    }

    override fun listener() {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        rootView.postDelayed({
           // startActivity(Intent(this, HomeActivity::class.java))
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }, 2000)

    }
}
