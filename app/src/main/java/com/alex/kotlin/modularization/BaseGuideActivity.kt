package com.alex.kotlin.modularization

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.callback.NavCallback
import com.alibaba.android.arouter.launcher.ARouter

class BaseGuideActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_guide)

        val uri = intent.data
        ARouter.getInstance().build(uri).navigation(this, object : NavCallback() {
            override fun onArrival(postcard: Postcard?) {
                finish()
            }
        })
    }
}
