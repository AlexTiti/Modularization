package com.alex.kotlin.base

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.facade.service.SerializationService
import com.google.gson.Gson
import java.lang.reflect.Type

@Route(path = "/base/JsonObjectImpl")
class JsonObjectImpl:SerializationService {

    override fun <T : Any?> json2Object(input: String?, clazz: Class<T>?): T {
        return Gson().fromJson(input,clazz)
    }

    override fun init(context: Context?) {
    }

    override fun object2Json(instance: Any?): String {
        return Gson().toJson(instance)
    }

    override fun <T : Any?> parseObject(input: String?, clazz: Type?): T {
        return Gson().fromJson(input,clazz)
    }
}