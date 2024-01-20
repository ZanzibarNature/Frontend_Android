package com.kawatrainingcenter.zanzibarnature.data.kawaApi.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://contentmanagement-kawa-foundation-app-dev.apps.ocp6-inholland.joran-bergfeld.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
}