package com.kawatrainingcenter.zanzibarnature.data.kawaApi.module

import com.kawatrainingcenter.zanzibarnature.data.kawaApi.api.KawaApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class KawaModule {
    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): KawaApi = retrofit.create()
}