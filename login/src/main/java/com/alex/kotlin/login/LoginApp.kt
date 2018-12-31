package com.alex.kotlin.login

import android.app.Application
import com.alex.kotlin.base.BaseApp
import com.alex.kotlin.componentbase.ServiceFactory
import com.alex.kotlin.login.service.LoginService

class LoginApp : BaseApp() {
    override fun initModuleApp(application: Application) {
        ServiceFactory.getFactory().loginService = LoginService()
    }
    override fun onCreate() {
        super.onCreate()
        initModuleApp(this)
    }
}