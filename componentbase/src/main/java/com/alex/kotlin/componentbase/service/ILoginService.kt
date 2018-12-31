package com.alex.kotlin.componentbase.service

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager

interface ILoginService {

    /**
     * 判断是否登陆状态
     */
    fun isLogin(): Boolean

    /**
     * 获取登陆信息
     */
    fun getAccountId():String?

    fun newBlankFragment(activity: Activity,containerId:Int,fragmentManager: FragmentManager,bundle: Bundle,tag:String) : Fragment?

}