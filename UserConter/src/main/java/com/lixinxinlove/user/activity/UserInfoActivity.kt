package com.lixinxinlove.user.activity

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.kotlin.user.R
import com.lixinxinlove.base.activity.BaseActivity

@Route(path ="/user/userInfo")
class UserInfoActivity : BaseActivity() {


    override fun layoutId(): Int {
        return R.layout.activity_user_info
    }

    override fun listener() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}
