package com.example.tradebot.components

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tradebot.model.SimpleArbitrage
import com.example.tradebot.screens.ArbitrageViewModel
/*
@Composable
fun SimpleArbitrageGrid(onClick: () -> Unit){

    /*
    val items = listOf(
        SimpleArbitrage("",1,"USDT_USDC","USDT","/usdt.png","USDC","/usdc.png","SUSHISWAP","QUICKSWAP",
        listOf()),SimpleArbitrage("",1,"USDT_USDC","USDT","/usdt.png","USDC","/usdc.png","SUSHISWAP","QUICKSWAP",
            listOf()),SimpleArbitrage("","USDT_USDC","USDT","/usdt.png","USDC","/usdc.png","SUSHISWAP","QUICKSWAP",
            listOf()),SimpleArbitrage("","USDT_USDC","USDT","/usdt.png","USDC","/usdc.png","SUSHISWAP","QUICKSWAP",
            listOf()),SimpleArbitrage("","USDT_USDC","USDT","/usdt.png","USDC","/usdc.png","SUSHISWAP","QUICKSWAP",
            listOf()),SimpleArbitrage("","USDT_USDC","USDT","/usdt.png","USDC","/usdc.png","SUSHISWAP","QUICKSWAP",
            listOf()),SimpleArbitrage("","USDT_USDC","USDT","/usdt.png","USDC","/usdc.png","SUSHISWAP","QUICKSWAP",
            listOf()),SimpleArbitrage("","USDT_USDC","USDT","/usdt.png","USDC","/usdc.png","SUSHISWAP","QUICKSWAP",
            listOf()),SimpleArbitrage("","USDT_USDC","USDT","/usdt.png","USDC","/usdc.png","SUSHISWAP","QUICKSWAP",
            listOf()),SimpleArbitrage("","USDT_USDC","USDT","/usdt.png","USDC","/usdc.png","SUSHISWAP","QUICKSWAP",
            listOf()),SimpleArbitrage("","USDT_USDC","USDT","/usdt.png","USDC","/usdc.png","SUSHISWAP","QUICKSWAP",
            listOf()),SimpleArbitrage("","USDT_USDC","USDT","/usdt.png","USDC","/usdc.png","SUSHISWAP","QUICKSWAP",
            listOf()),SimpleArbitrage("","USDT_USDC","USDT","/usdt.png","USDC","/usdc.png","SUSHISWAP","QUICKSWAP",
            listOf()),SimpleArbitrage("","USDT_USDC","USDT","/usdt.png","USDC","/usdc.png","SUSHISWAP","QUICKSWAP",
            listOf()),SimpleArbitrage("","USDT_USDC","USDT","/usdt.png","USDC","/usdc.png","SUSHISWAP","QUICKSWAP",
            listOf()),SimpleArbitrage("","USDT_USDC","USDT","/usdt.png","USDC","/usdc.png","SUSHISWAP","QUICKSWAP",
            listOf()))*/
    LazyVerticalGrid(
        columns = GridCells.Fixed(2)
    ) {
        items(items.size) { index ->
            SimpleArbitrageGridItem(items[index]){
                onClick()
            }
        }
    }
}*/



@Preview(showBackground = true)
@Composable
fun PreviewSimpleArbitrage(){

}