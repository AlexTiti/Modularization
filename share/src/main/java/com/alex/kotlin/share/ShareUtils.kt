package com.alex.kotlin.share

import android.util.Log
import com.alex.kotlin.componentbase.service.IShare

class ShareUtils : IShare {

    var success = false
    override fun shareSuccess(): Boolean {
       return success
    }

    override fun share(message: String) {
        Log.e("=====","$message")
        success = true
    }
}