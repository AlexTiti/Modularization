package com.alex.kotlin.login.service

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.alex.kotlin.componentbase.service.ILoginService
import com.alex.kotlin.login.ui.BlankFragment

class LoginService : ILoginService {

    override fun newBlankFragment(
        activity: Activity,
        containerId: Int,
        fragmentManager: FragmentManager,
        bundle: Bundle,
        tag: String
    ): Fragment? {
     val fragment = BlankFragment.newInstance()
        fragmentManager.beginTransaction().add(containerId,fragment,tag).commit()
        return fragment
    }

    override fun isLogin(): Boolean {
        return true
    }

    override fun getAccountId(): String? {
        return "LoginUserName"
    }
}