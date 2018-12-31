package com.alex.kotlin.modularization

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.alex.kotlin.base.PrintService
import com.alex.kotlin.componentbase.ServiceFactory
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.launcher.ARouter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @Autowired(name = "/login/print_service")
    @JvmField
    var service: PrintService? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ARouter.getInstance().inject(this)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            //1、普通跳转
            ARouter.getInstance().build("/login/activity").navigation()
            //2、携带参数跳转，参数接收可以是getIntent（）中获取，也可以使用@Autowired注解自动转换
//            ARouter.getInstance().build("/login/activity")
//                .withString("Name", "USer")
//                .withInt("Age", 10)
//                .navigation()

            // 直接传递Bundle
//            val params = Bundle()
//            ARouter.getInstance()
//                .build("/home/main")
//                .with(params)
//                .navigation()

            //3、根据Uri跳转界面
//            val uri = Uri.parse("http://a.alibaba.com:8888/login/urlActivity")

            //在请求地址中添加参数
//            val uri = Uri.parse("http://a.alibaba.com:8888/login/urlActivity?name=AAA,age=10")
//            ARouter.getInstance().build(uti).navigation()
            //加载WebView，从中点击Link跳转和应用界面（添加并转换自定义对象）
//            ARouter.getInstance().build("/app/webActivity")
//                .withString("url","file:///android_asset/test.html").navigation()

            //4、动画跳转(navigation中传入this)
//            ARouter.getInstance().build("/login/activity")
//                .withTransition(R.anim.login_anim_in,R.anim.login_anim_out)
//                .navigation(this)
            //新版动画使用ActivityOptionsCompat
//            val compat = ActivityOptionsCompat.makeScaleUpAnimation(button,button.width,button.height,0,0)
//            ARouter.getInstance().build("/login/activity")
//                .withOptionsCompat(compat)
//                .navigation()
            //5、跳转回调
            //ARouter.getInstance().build("/login/activity").navigation(this,1001)
            //2018-12-18 14:17:40.515 27401-27401/com.alex.kotlin.modularization E/=====: 1000
            //6、跳转拦截（AOP）
            // 在给 Activity设置注解时除可设置必须的path外，还可以添加extra标记必须的条件（如登陆状态），然后根据extra标记拦截
            // @Route(path = "/login/activity",extras = 10)
            // if ("/login/activity" == postcard?.path && postcard.extra == 15){
            // ARouter.getInstance().build("/login/activity").navigation()
            //// 使用绿色通道(跳过所有的拦截器)
            ARouter.getInstance().build("/login/activity").greenChannel().navigation();

            //7、跳转监听
//            ARouter.getInstance().build("/login/activity").navigation(this,object :NavCallback(){
//                override fun onArrival(postcard: Postcard?) {
//                    Log.e("=====","跳转完成")
//                }
//
//                override fun onFound(postcard: Postcard?) {
//                    super.onFound(postcard)
//                    Log.e("=====","找到目标")
//                }
//
//                override fun onInterrupt(postcard: Postcard?) {
//                    super.onInterrupt(postcard)
//                    Log.e("=====","跳转被拦截")
//                }
//
//                override fun onLost(postcard: Postcard?) {
//                    super.onLost(postcard)
//                    Log.e("=====","未找到目标")
//                }
//
//            })
            //2018-12-18 14:38:21.659 28628-28628/com.alex.kotlin.modularization E/=====: 找到目标
            //2018-12-18 14:38:21.699 28628-28628/com.alex.kotlin.modularization E/=====: 跳转完成
            //修改Intercepter 中拦截事件 callback?.onInterrupt(null)
            //2018-12-18 14:39:33.658 28856-28856/com.alex.kotlin.modularization E/=====: 找到目标
            //2018-12-18 14:39:33.663 28856-28931/com.alex.kotlin.modularization E/=====: 跳转被拦截

            // 8、使用服务
            //声明接口服务并继承IProvider
            //实现服务并添加Route注解
            //使用@Autowired注解绑定服务的实现类(推荐使用)
            //ARouter.getInstance().navigation(PrintService::class.java)
            //ARouter.getInstance().build("/login/print_service").navigation() as PrintService?

            service?.print("================")
            //2018-12-18 15:03:06.113 30657-30657/com.alex.kotlin.modularization I/System.out: ================



        }
        ServiceFactory.getFactory().loginService?.newBlankFragment(
            this,
            R.id.layout_frame,
            supportFragmentManager,
            Bundle(),
            ""
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1001 && resultCode == Activity.RESULT_OK) {
            Log.e("=====", "${data?.getIntExtra("Result", 1)}")
        }
    }

}
