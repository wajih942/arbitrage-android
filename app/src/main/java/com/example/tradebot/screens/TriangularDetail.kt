package com.example.tradebot.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.tradebot.components.BarChart
import com.example.tradebot.components.FirstSwapSimple
import com.example.tradebot.components.FirstSwapTriangular
import com.example.tradebot.components.ReturnButton
import com.example.tradebot.components.SecondSwapSimple
import com.example.tradebot.components.SecondSwapTriangular
import com.example.tradebot.components.ThirdSwapTriangular
import com.example.tradebot.components.format
import com.example.tradebot.model.TriangularPath
import com.example.tradebot.model.TriangularPathItem
import com.example.tradebot.network.SocketHandler


@Composable
fun TriangularDetail(triangleData : TriangularPath,navController: NavController){
    // The following lines connects the Android app to the server.
    SocketHandler.setSocket()
    SocketHandler.establishConnection()
    val mSocket = SocketHandler.getSocket()
    val amountIn : MutableState<String> = remember { mutableStateOf("") }
    val firstSwap : MutableState<String> = remember { mutableStateOf("") }
    val secondSwap : MutableState<String> = remember { mutableStateOf("") }
    val amountOut : MutableState<String> = remember { mutableStateOf("") }
    mSocket.on("triangularArbitrage${triangleData.ID}") { args ->
        if (args[0] != null && args[1] != null && args[2] != null) {
            val aI = args[0] as String
            val aO = args[3] as String
            val fS = args[1] as String
            val sS = args[2] as String
            amountIn.value = format(aI)
            amountOut.value = format(aO)
            firstSwap.value = format(fS)
            secondSwap.value = format(sS)
        }
    }
    Surface(
        modifier = Modifier
            .fillMaxSize(), color = Color.Black
    ){
        val barChartInputsPercent = (1..triangleData.arbitrageOpportunities.size).map { (1..100).random().toFloat() }
        val scrollState = rememberScrollState()
        Log.d("aa",triangleData.toString())
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .padding(0.dp)
        ){
            ReturnButton {
                navController.popBackStack()
            }
            Spacer(modifier = Modifier.padding(vertical = 15.dp))
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                Text(text = "Amount In : ${amountIn.value}", color = Color.White, fontSize = 15.sp, modifier = Modifier.width(180.dp), textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.padding(5.dp))
                Text(text = "Amount Out : ${amountOut.value}", color = Color.White, fontSize = 15.sp, modifier = Modifier.width(180.dp),textAlign = TextAlign.Center)
            }
            Spacer(modifier = Modifier.padding(vertical = 15.dp))
            FirstSwapTriangular(triangular = triangleData, amountIn = amountIn.value, firstSwap = firstSwap.value)
            SecondSwapTriangular(triangular = triangleData,firstSwap = firstSwap.value, secondSwap = secondSwap.value)
            ThirdSwapTriangular(triangular = triangleData, secondSwap = secondSwap.value, amountOut = amountOut.value)
            Spacer(modifier = Modifier.padding(vertical = 15.dp))
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                Text(text = "Captured Arbitrage Opportunities : ", color = Color.White, fontSize = 15.sp, textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.padding(15.dp))
                Text(text = "${triangleData.arbitrageOpportunities.size}", color = Color.White, fontSize = 15.sp, textAlign = TextAlign.Center)
            }
            BarChart(values = barChartInputsPercent)

        }
    }
}


@Preview
@Composable
fun PreviewTriangularDetail(){
    TriangularDetail(triangleData = TriangularPath("1","2", listOf(
        TriangularPathItem("","USDT_USDC","USDT","/usdt.png","USDC","/usdc.png"),
        TriangularPathItem("","USDT_USDC","USDT","/usdt.png","USDC","/usdc.png"),
        TriangularPathItem("","USDT_USDC","USDT","/usdt.png","USDC","/usdc.png")
    ),"SUSHISWAP","SUSHISWAP","SUSHISWAP",
        listOf()
    ),navController = rememberNavController())
}