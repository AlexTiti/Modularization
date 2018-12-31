package com.alex.kotlin.componentbase.empty_service

import com.alex.kotlin.componentbase.service.IShare

class ShareEmpty : IShare{
    override fun shareSuccess(): Boolean {
        return false
    }

    override fun share(message: String) {

    }

}