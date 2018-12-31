package com.alex.kotlin.componentbase.empty_service

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.alex.kotlin.componentbase.service.ILoginService

class LoginServiceEmpty : ILoginService {
    override fun newBlankFragment(
        activity: Activity,
        containerId: Int,
        fragmentManager: FragmentManager,
        bundle: Bundle,
        tag: String
    ): Fragment? {
        return null
    }


    override fun isLogin(): Boolean {
        return false
    }

    override fun getAccountId(): String? {
        return null
    }
}