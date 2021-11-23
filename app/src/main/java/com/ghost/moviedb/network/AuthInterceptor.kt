package com.ghost.moviedb.network

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val url = chain.request().url()
            .newBuilder()
            .addQueryParameter("api_key", "ef201759353c7f6afb02f66a5a5386bc")
            .build()
        val request = chain.request().newBuilder().url(url).build()
        return chain.proceed(request)
    }
}