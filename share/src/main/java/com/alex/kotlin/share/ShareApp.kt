package com.alex.kotlin.share

import android.app.Application
import com.alex.kotlin.base.BaseApp
import com.alex.kotlin.componentbase.ServiceFactory

class ShareApp : BaseApp() {

    override fun onCreate() {
        super.onCreate()
        initModuleApp(this)
    }
    override fun initModuleApp(application: Application) {
        ServiceFactory.getFactory().share = ShareUtils()
    }
}