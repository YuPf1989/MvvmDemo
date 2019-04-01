package com.rain.mvvmdemo.data.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

/**
 * Author:rain
 * Date:2019/3/27 9:12
 * Description:
 */
object ServiceCreator {
    private const val BASE_URL = "http://guolin.tech/"
    private val httpClient = OkHttpClient.Builder()
    private val builder = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(httpClient.build())
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())

    private val retrofit: Retrofit = builder.build()
    fun <T> create(serviceClass: Class<T>): T {
        return retrofit.create(serviceClass)
    }
}