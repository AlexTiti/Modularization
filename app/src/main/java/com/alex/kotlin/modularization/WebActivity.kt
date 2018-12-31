package com.alex.kotlin.modularization

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import kotlinx.android.synthetic.main.activity_web.*

@Route(path = "/app/webActivity")
class WebActivity : AppCompatActivity() {

    @Autowired
    @JvmField
    var url : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ARouter.getInstance().inject(this)
        setContentView(R.layout.activity_web)
//        web_view.webViewClient = object : WebViewClient(){
//            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
//                view?.loadUrl(url)
//                return true
//            }
//        }
        web_view.loadUrl(url)
    }
}
