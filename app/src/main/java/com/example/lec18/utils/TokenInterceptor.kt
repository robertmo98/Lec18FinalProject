package com.example.lec18.utils


import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class TokenInterceptor(
    private val queryParam:String = "api_key",
    private val queryValue:String = "b3b1492d3e91e9f9403a2989f3031b0c"
): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()

        var url = original
            .url.newBuilder()
            .addQueryParameter(queryParam, queryValue)
            .build()

        val request = original.newBuilder().url(url).build()

        return chain.proceed(request)
    }
}