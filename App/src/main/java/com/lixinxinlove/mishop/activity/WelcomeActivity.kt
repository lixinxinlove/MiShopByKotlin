package com.lixinxinlove.mishop.activity


import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import com.lixinxinlove.base.activity.BaseActivity
import com.lixinxinlove.mishop.App
import com.lixinxinlove.mishop.R
import com.lixinxinlove.user.activity.LoginActivity
import kotlinx.android.synthetic.main.activity_welcome.*


/**
 * 欢迎页
 */
class WelcomeActivity : BaseActivity() {

    override fun layoutId(): Int {
        return R.layout.activity_welcome
    }

    override fun listener() {}

    override fun onCreate(savedInstanceState: Bundle?) {
        //全屏
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        rootView.postDelayed({
            if (App.isLogin) {
                startActivity(Intent(this, HomeActivity::class.java))
            } else {
                startActivity(Intent(this, LoginActivity::class.java))
            }
            finish()
        }, 2000)

    }
}
