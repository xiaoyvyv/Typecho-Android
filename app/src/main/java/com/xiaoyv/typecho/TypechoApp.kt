package com.xiaoyv.typecho

import android.app.Application
import com.xiaoyv.blueprint.BluePrint
import com.xiaoyv.typecho.api.BlogApiManager
import retrofit2.Retrofit

/**
 * TypechoApp
 *
 * @author why
 * @since 2023/10/11
 */
class TypechoApp : Application() {

    override fun onCreate() {
        super.onCreate()
        BluePrint.init(this, false)
    }
}