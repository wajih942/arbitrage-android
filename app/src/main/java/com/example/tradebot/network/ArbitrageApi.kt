package com.example.tradebot.network

import com.example.tradebot.model.SimpleArbitrageList
import com.example.tradebot.model.TokenList
import com.example.tradebot.model.TriangularPathList
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface ArbitrageApi {
    @GET("api/getTokens")
    suspend fun getAllTokens() : TokenList

    @GET("api/getsimplepairs")
    suspend fun getSimplePairs() : SimpleArbitrageList

    @GET("api/gettriangularpath")
    suspend fun getTriangularPairs() : TriangularPathList

    @GET("api/filtredsimplepairs")
    suspend fun getFiltredSimple(@Query("firstmarket") firstmarket : String,@Query("secondmarket") secondmarket : String,@Query("sort") sort : String): SimpleArbitrageList

    @GET("api/getFiltredTriangularPath")
    suspend fun getFiltredTriangular(@Query("firstmarket") firstmarket : String,@Query("secondmarket") secondmarket : String,@Query("thirdmarket") thirdmarket : String,@Query("sort") sort : String): TriangularPathList
}