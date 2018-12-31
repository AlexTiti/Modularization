package com.alex.kotlin.share

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.alex.kotlin.componentbase.ServiceFactory
import com.alibaba.android.arouter.facade.annotation.Route
import kotlinx.android.synthetic.main.share_activity_share.*

@Route(path = "/share/activity")
class ShareActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.share_activity_share)
        val login = ServiceFactory.getFactory().loginService
        login?.let {
            if (it.isLogin()){
                textView.text = it.getAccountId()
            }
        }
    }

}
