package com.alex.kotlin.base

import android.app.Application

abstract class BaseApp : Application() {
    /**
     * 初始化组件中的Application
     */
    abstract fun initModuleApp(application: Application)
}