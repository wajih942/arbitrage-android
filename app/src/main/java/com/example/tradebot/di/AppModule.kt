package com.example.tradebot.di

import com.example.tradebot.network.ArbitrageApi
import com.example.tradebot.repository.ArbitrageRepository
import com.example.tradebot.util.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun providesArbitrageRepository(api:ArbitrageApi) = ArbitrageRepository(api)


    @Singleton
    @Provides
    fun provideTokensApi(): ArbitrageApi {
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ArbitrageApi::class.java)
    }
}