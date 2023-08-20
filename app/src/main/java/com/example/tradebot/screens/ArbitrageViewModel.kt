package com.example.tradebot.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tradebot.data.DataOrException
import com.example.tradebot.model.SimpleArbitrage
import com.example.tradebot.model.Token
import com.example.tradebot.model.TriangularPath
import com.example.tradebot.repository.ArbitrageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArbitrageViewModel @Inject constructor(private val repository: ArbitrageRepository):
    ViewModel() {
    val data : MutableState<DataOrException<ArrayList<Token>, Boolean, Exception>> = mutableStateOf(
        DataOrException(null,true,Exception(""))
    )

    val data1 : MutableState<DataOrException<ArrayList<SimpleArbitrage>, Boolean, Exception>> = mutableStateOf(
        DataOrException(null,true,Exception(""))
    )
    val data11 : MutableState<DataOrException<ArrayList<SimpleArbitrage>, Boolean, Exception>> = mutableStateOf(
        DataOrException(null,true,Exception(""))
    )

    val data2 : MutableState<DataOrException<ArrayList<TriangularPath>, Boolean, Exception>> = mutableStateOf(
        DataOrException(null,true,Exception(""))
    )
    val data22 : MutableState<DataOrException<ArrayList<TriangularPath>, Boolean, Exception>> = mutableStateOf(
        DataOrException(null,true,Exception(""))
    )

    fun getTriangularPairs(){
        viewModelScope.launch {
            data2.value.loading = true
            data2.value = repository.getTriangularArbitrageTokens()
            if(data2.value.data.toString().isNotEmpty()){
                data2.value.loading = false
            }
        }
    }
    fun getTriangularPairs(firstMarket:String,secondMarket:String,thirdmarket:String,sort:String){
        viewModelScope.launch {
            data22.value.loading = true
            data22.value = repository.filterTriangularArbitrageTokens(firstMarket,secondMarket,thirdmarket,sort)
            if(data22.value.data.toString().isNotEmpty()){
                data22.value.loading = false
            }
        }
    }
    fun getSimplePairs(){
        viewModelScope.launch {
            data1.value.loading = true
            data1.value = repository.getSimpleArbitrageTokens()
            if(data1.value.data.toString().isNotEmpty()){
                data1.value.loading = false
            }
        }
    }
    fun filterSimplePairs(firstMarket:String,secondMarket:String,sort:String){
        viewModelScope.launch {
            data11.value.loading = true
            data11.value = repository.filterSimpleArbitrageTokens(firstMarket,secondMarket,sort)
            if(data11.value.data.toString().isNotEmpty()){
                data11.value.loading = false
            }
        }
    }

    fun getAllQuestions(){
        viewModelScope.launch {
            data.value.loading = true
            data.value = repository.getAllTokens()
            if(data.value.data.toString().isNotEmpty()){
                data.value.loading = false
            }
        }
    }
}