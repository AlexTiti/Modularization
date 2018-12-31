package com.alex.kotlin.base

import com.alibaba.android.arouter.facade.template.IProvider

interface PrintService : IProvider{
    fun print(message:String)
}