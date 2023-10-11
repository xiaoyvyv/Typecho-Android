package com.xiaoyv.typecho.api

import com.xiaoyv.typecho.api.typecho.TypechoApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

/**
 * BlogApiManager
 *
 * @author why
 * @since 2023/8/5
 */
class BlogApiManager {

    private val httpClient by lazy {
        OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .build()
    }

    internal var retrofit: Retrofit? = null
    internal var typechoApi: TypechoApi? = null
    internal var blogType = BlogType.TYPE_TYPECHO

    fun initApi(host: String, port: Int, https: Boolean, @BlogType type: Int) {
        blogType = type

        when (type) {
            BlogType.TYPE_TYPECHO -> {
                retrofit = Retrofit.Builder()
                    .baseUrl(buildUrl(host, port, https, "/index.php/action/xmlrpc"))
                    .client(httpClient)
                    .build()

                typechoApi = requireNotNull(retrofit).create(TypechoApi::class.java)
            }

            BlogType.TYPE_WORDPRESS -> {
                retrofit = Retrofit.Builder()
                    .baseUrl(buildUrl(host, port, https, "/index.php"))
                    .client(httpClient)
                    .build()

                typechoApi = requireNotNull(retrofit).create(TypechoApi::class.java)
            }

            else -> {
                throw IllegalArgumentException("BlogType: $type not support!")
            }
        }
    }

    /**
     * build baseUrl
     */
    private fun buildUrl(host: String, port: Int, https: Boolean, path: String): String {
        val scheme = if (https) "https://" else "http://"
        return "$scheme$host:$port$path"
    }
}








