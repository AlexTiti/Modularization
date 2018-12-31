package com.alex.kotlin.base

class AppConfig {
    companion object {
       private const val loginModule = "com.alex.kotlin.login.LoginApp"
       private const val shareModule = "com.alex.kotlin.share.ShareApp"
      val moduleApps = arrayOf(loginModule, shareModule)
    }
}