package com.alex.kotlin.componentbase

import com.alex.kotlin.componentbase.empty_service.LoginServiceEmpty
import com.alex.kotlin.componentbase.empty_service.ShareEmpty
import com.alex.kotlin.componentbase.service.ILoginService
import com.alex.kotlin.componentbase.service.IShare

class ServiceFactory {

    var loginService: ILoginService? = null
        get() {
            if (field == null) {
                field = LoginServiceEmpty()
            }
            return field
        }

    var share: IShare? = null
        get() {
            if (field == null) {
                field = ShareEmpty()
            }
            return field
        }

    private constructor()

    companion object {
        fun getFactory() = InnerFactory.serviceFactory
    }

    private class InnerFactory {
        companion object {
            val serviceFactory = ServiceFactory()
        }
    }
}