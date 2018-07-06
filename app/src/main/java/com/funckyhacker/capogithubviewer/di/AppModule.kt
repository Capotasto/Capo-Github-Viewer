package com.funckyhacker.capofiler.di

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import javax.inject.Singleton

@Module(subcomponents = [
    (MainComponent::class)
])
class AppModule {
    companion object {
        private const val GITHUB_URL = "https://api.github.com/"
    }

    /**
     * Retrofit Provider
     */
    @Singleton @Provides
    fun provideGithubRetrofit(okHttpClient: OkHttpClient, gson: Gson) : Retrofit {
        return Retrofit.Builder().baseUrl(GITHUB_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
    }

    /**
     * OkHttp Provider
     */
    @Singleton @Provides
    fun provideOkHttpClient(): OkHttpClient{
        val loggingInterceptor = HttpLoggingInterceptor { msg -> Timber.tag("OkHttp").v(msg) }
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()
    }

    /**
     * Gson Provider
     */
    @Singleton @Provides
    fun provideGson(): Gson{
        return Gson()
    }
}
