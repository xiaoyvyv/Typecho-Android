package com.xiaoyv.typecho.api

/**
 * BlogApi
 *
 * @author why
 * @since 2023/10/11
 */
object BlogApi {
    private val apiManager by lazy { BlogApiManager() }

    suspend fun login(username: String, password: String) {
        when (apiManager.blogType) {
            BlogType.TYPE_TYPECHO -> {

            }
        }
    }
}