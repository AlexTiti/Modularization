package com.alex.kotlin.base

import android.content.Context
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Interceptor
import com.alibaba.android.arouter.facade.callback.InterceptorCallback
import com.alibaba.android.arouter.facade.template.IInterceptor

@Interceptor(priority = 8)
class LoginInterceptor : IInterceptor {

    override fun process(postcard: Postcard?, callback: InterceptorCallback?) {
        if ("/login/activity" == postcard?.path && postcard.extra == 15) {
            postcard.path = "/share/activity"
            callback?.onInterrupt(null)
        } else {
            callback?.onContinue(postcard)
        }
    }

    override fun init(context: Context?) {
    }

}