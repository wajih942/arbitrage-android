package com.example.tradebot.repository

import android.util.Log
import com.example.tradebot.data.DataOrException
import com.example.tradebot.model.SimpleArbitrage
import com.example.tradebot.model.Token
import com.example.tradebot.model.TriangularPath
import com.example.tradebot.network.ArbitrageApi
import javax.inject.Inject

class ArbitrageRepository @Inject constructor(private val api: ArbitrageApi) {
    private val tokensOrException = DataOrException<ArrayList<Token>,Boolean,Exception>()

    private val arbitragePairsOrException = DataOrException<ArrayList<SimpleArbitrage>,Boolean,Exception>()

    private val triangularPairsOrException = DataOrException<ArrayList<TriangularPath>,Boolean,Exception>()





    suspend fun getTriangularArbitrageTokens(): DataOrException<ArrayList<TriangularPath>,Boolean,Exception>{
        try {
            triangularPairsOrException.loading = true
            triangularPairsOrException.data = api.getTriangularPairs()
            if (triangularPairsOrException.data.toString().isNotEmpty()) triangularPairsOrException.loading = false
        }catch (exception :Exception){
            triangularPairsOrException.e = exception
            Log.d("err" , "${triangularPairsOrException.e!!.localizedMessage}")
        }
        return triangularPairsOrException
    }
    suspend fun filterTriangularArbitrageTokens(firstMarket : String,secondMarket:String,thirdMarket:String,sort:String): DataOrException<ArrayList<TriangularPath>,Boolean,Exception>{
        try {
            triangularPairsOrException.loading = true
            triangularPairsOrException.data = api.getFiltredTriangular(firstMarket,secondMarket,thirdMarket,sort)
            if (triangularPairsOrException.data.toString().isNotEmpty()) triangularPairsOrException.loading = false
        }catch (exception :Exception){
            triangularPairsOrException.e = exception
            Log.d("err" , "${triangularPairsOrException.e!!.localizedMessage}")
        }
        return triangularPairsOrException
    }

    suspend fun getSimpleArbitrageTokens(): DataOrException<ArrayList<SimpleArbitrage>,Boolean,Exception>{
        try {
            arbitragePairsOrException.loading = true
            arbitragePairsOrException.data = api.getSimplePairs()
            if (arbitragePairsOrException.data.toString().isNotEmpty()) arbitragePairsOrException.loading = false
        }catch (exception :Exception){
            arbitragePairsOrException.e = exception
            Log.d("err" , "${arbitragePairsOrException.e!!.localizedMessage}")
        }
        return arbitragePairsOrException
    }

    suspend fun filterSimpleArbitrageTokens(firstMarket : String,secondMarket:String,sort:String): DataOrException<ArrayList<SimpleArbitrage>,Boolean,Exception>{
        try {
            arbitragePairsOrException.loading = true
            arbitragePairsOrException.data = api.getFiltredSimple(firstMarket,secondMarket,sort)
            if (arbitragePairsOrException.data.toString().isNotEmpty()) arbitragePairsOrException.loading = false
        }catch (exception :Exception){
            arbitragePairsOrException.e = exception
            Log.d("err" , "${arbitragePairsOrException.e!!.localizedMessage}")
        }
        return arbitragePairsOrException
    }
    suspend fun getAllTokens(): DataOrException<ArrayList<Token>,Boolean,Exception>{
        try {
            tokensOrException.loading = true
            tokensOrException.data = api.getAllTokens()
            if (tokensOrException.data.toString().isNotEmpty()) tokensOrException.loading = false
        }catch (exception :Exception){
            tokensOrException.e = exception
            Log.d("err" , "${tokensOrException.e!!.localizedMessage}")
        }
        return tokensOrException
    }

}