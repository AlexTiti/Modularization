package com.alex.kotlin.login.service

import android.content.Context
import com.alex.kotlin.base.PrintService
import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = "/login/print_service")
class PrintServiceImpl : PrintService {
    override fun init(context: Context?) {
    }

    override fun print(message: String) {
       System.out.println(message)
    }
}