package com.sharks.ouioui.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.sharks.ouioui.data.remote.DestinationApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val BASE_URL = "https://api.opentripmap.com/0.1/en/"

    @Provides
    @Singleton
    fun provideGson(): Gson = GsonBuilder().create()


    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder().build()

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun provideDestinationApiService(retrofit: Retrofit): DestinationApiService =
        retrofit.create(DestinationApiService::class.java)

    @Provides
    fun provideApiKey(): String = "5ae2e3f221c38a28845f05b694eee803df8331637d495362639ecfea"
}