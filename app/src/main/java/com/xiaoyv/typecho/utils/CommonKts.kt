package com.xiaoyv.typecho.utils

import android.util.Log

/**
 * CommonKts
 *
 * @author why
 * @since 2023/8/5
 */
fun Any.debugLog(msg: String?) {
    Log.e(javaClass.simpleName, msg.toString())
}