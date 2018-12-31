package com.alex.kotlin.login.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.alex.kotlin.login.R
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import kotlinx.android.synthetic.main.login_activity_login.*

@Route(path = "/login/activity",extras = 15)
class LoginActivity : AppCompatActivity() {

    @Autowired(name = "Name")
    @JvmField var name : String? = null
    @Autowired(name = "Age")
    @JvmField var age = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        ARouter.getInstance().inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity_login)

        Log.e("======", "$name===$age")
        button.setOnClickListener {
            ARouter.getInstance().build("/share/activity").navigation()

        }

        val intent = Intent()
        intent.putExtra("Result",1000)
        setResult(Activity.RESULT_OK, intent)
    }

}
