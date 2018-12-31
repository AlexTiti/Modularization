package com.alex.kotlin.modularization

import android.app.Application
import com.alex.kotlin.base.AppConfig
import com.alex.kotlin.base.BaseApp
import com.alibaba.android.arouter.launcher.ARouter

class MainModuleApp : BaseApp() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG){
            //开启Debug
            ARouter.openDebug()
            //开启打印日志
            ARouter.openLog()
        }
        //初始化ARouter
        ARouter.init(this)
        initModuleApp(this)
    }

    override fun initModuleApp(application: Application) {
        for (moduleName in AppConfig.moduleApps){
            try {
                val classApp = Class.forName(moduleName)
                val instance: BaseApp = classApp.newInstance() as BaseApp
                instance.initModuleApp(this)
            }catch (e:Exception){
            }
        }
    }

}