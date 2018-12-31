package com.alex.kotlin.login.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.alex.kotlin.base.User
import com.alex.kotlin.login.R
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter

@Route(path = "/login/urlActivity")
class UrlActivity : AppCompatActivity() {

    @Autowired
    @JvmField
    var name: String? = null
    @Autowired
    @JvmField
    var age: Int = 0

    @Autowired
    @JvmField
    var user : User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ARouter.getInstance().inject(this)
        setContentView(R.layout.activity_url)

        Log.e("======", name + "$age")
        Log.e("======", user.toString())



//        val uri = intent.data
//        ARouter.getInstance().build(uri).navigation()
    }
}
