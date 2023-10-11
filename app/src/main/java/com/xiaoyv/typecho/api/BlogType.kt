package com.xiaoyv.typecho.api

import androidx.annotation.IntDef

/**
 * BlogType
 *
 * @author why
 * @since 2023/10/11
 */
@IntDef(
    BlogType.TYPE_TYPECHO,
    BlogType.TYPE_WORDPRESS,
)
@Retention(AnnotationRetention.SOURCE)
annotation class BlogType {
    companion object {
        const val TYPE_TYPECHO = 1
        const val TYPE_WORDPRESS = 2
    }
}
