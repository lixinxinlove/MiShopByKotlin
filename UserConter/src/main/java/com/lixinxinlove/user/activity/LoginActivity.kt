package com.lixinxinlove.user.activity

import android.net.Uri
import android.os.Bundle
import com.jaeger.library.StatusBarUtil
import com.kotlin.user.R
import com.lixinxinlove.base.activity.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {

    override fun layoutId(): Int {
        return R.layout.activity_login
    }

    override fun listener() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        StatusBarUtil.setDarkMode(this)
        StatusBarUtil.setTransparent(this)
        super.onCreate(savedInstanceState)
        var uri = "android.resource://" + packageName + "/" + R.raw.login
        vvLogin.requestFocus()
        vvLogin.setOnCompletionListener { vvLogin.start() }
        vvLogin.setVideoURI(Uri.parse(uri))
        vvLogin.start()
    }
}
