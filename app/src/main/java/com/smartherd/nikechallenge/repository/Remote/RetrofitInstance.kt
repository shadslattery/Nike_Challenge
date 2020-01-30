package com.smartherd.nikechallenge.repository.Remote

import com.smartherd.nikechallenge.utils.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitInstance {

    val INSTANCE: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val interceptor: HttpLoggingInterceptor
        get() = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    private val client: OkHttpClient
        get() = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .connectTimeout(2,TimeUnit.MINUTES)
            .readTimeout(2,TimeUnit.MINUTES)
            .writeTimeout(2,TimeUnit.MINUTES)
            .build()


    fun getUrbanService():UrbanService {
        return INSTANCE.create(UrbanService::class.java)
    }
}