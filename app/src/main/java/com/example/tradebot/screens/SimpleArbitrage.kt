package com.example.tradebot.screens

import android.annotation.SuppressLint
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType.Companion.Uri
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.tradebot.components.DropDownFilter
import com.example.tradebot.components.DropdownMenuExample
import com.example.tradebot.components.ResetButton
import com.example.tradebot.components.SearchButton

import com.example.tradebot.components.SimpleArbitrageGridItem
import com.example.tradebot.components.percentage
import com.example.tradebot.model.SimpleArbitrage
import com.example.tradebot.network.SocketHandler
import com.google.accompanist.flowlayout.SizeMode


@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SimpleArbitrage(viewModel: ArbitrageViewModel = hiltViewModel(), navController: NavController){

    var list : MutableList<SimpleArbitrage> = mutableStateListOf<SimpleArbitrage>()
    var simpleArbitragePairs =
        viewModel.data1.value.data?.toMutableList()
    var simpleArbitragePairsFiltred =
        viewModel.data11.value.data?.toMutableList()
    if (simpleArbitragePairs != null) {
        list = simpleArbitragePairs
    }
    var first = mutableStateOf("First Market")
    var second = mutableStateOf("Second Market")
    var sort = mutableStateOf("Sort")
    // The following lines connects the Android app to the server.
    SocketHandler.setSocket()
    SocketHandler.establishConnection()
    val mSocket = SocketHandler.getSocket()

    // args[0] is the data from the server
    // Change "as Int" according to the data type
    // Example "as String" or write nothing
    // Logging the data is optional

    Surface(modifier = Modifier
        .fillMaxSize(),
        color = Color.Black
    ) {
        val scrollState = rememberScrollState()
        Column(modifier = Modifier
            .padding(5.dp)
            .verticalScroll(scrollState)
            .fillMaxSize()) {
            Spacer(modifier = Modifier.padding(vertical = 15.dp))
            Text(text = "Simple Arbitrage", color = Color.White, fontSize = 30.sp, fontWeight = FontWeight.ExtraBold)
            Spacer(modifier = Modifier.padding(vertical = 15.dp))
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center, modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 3.dp)) {
                Text(text = "Choose The First Market", color = Color.White, fontSize = 15.sp,fontWeight = FontWeight.Bold, modifier = Modifier.width(220.dp))

                Row(modifier = Modifier.width(300.dp), horizontalArrangement = Arrangement.End){
                    DropdownMenuExample(selectedItem = first)
                }
            }
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center, modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 3.dp)) {
                Text(text = "Choose The Second Market", color = Color.White, fontSize = 15.sp,fontWeight = FontWeight.Bold,modifier = Modifier.width(220.dp))

                Row(modifier = Modifier.width(300.dp), horizontalArrangement = Arrangement.End) {
                    DropdownMenuExample(selectedItem = second)
                }
            }
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center, modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 3.dp)) {
                Text(text = "Filter By Arbitrage opportunity", color = Color.White, fontSize = 15.sp,fontWeight = FontWeight.Bold,modifier = Modifier.width(220.dp))

                Row(modifier = Modifier.width(300.dp), horizontalArrangement = Arrangement.End) {
                    DropDownFilter(selectedItem = sort)
                }
            }

            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center, modifier = Modifier
                .padding(horizontal = 10.dp)
                .fillMaxWidth()) {
                SearchButton {
                    viewModel.filterSimplePairs(first.value,second.value,sort.value)

                    if (simpleArbitragePairsFiltred != null) {
                        list = simpleArbitragePairsFiltred
                    }
                }
                Spacer(modifier = Modifier.padding(horizontal = 10.dp))
                ResetButton {
                    first.value = "First Market"
                    second.value = "Second Market"
                    sort.value = "Sort"
                }
            }
            viewModel.getSimplePairs()


            /*
            val items = listOf(
                com.example.tradebot.model.SimpleArbitrage(
                    "",
                    "AAAA_USDC",
                    "AAAA",
                    "/usdt.png",
                    "USDC",
                    "/usdc.png",
                    "SUSHISWAP",
                    "QUICKSWAP",
                    listOf()
                ), com.example.tradebot.model.SimpleArbitrage(
                    "",
                    "USDT_USDC",
                    "USDT",
                    "/usdt.png",
                    "USDC",
                    "/usdc.png",
                    "SUSHISWAP",
                    "QUICKSWAP",
                    listOf()
                ), com.example.tradebot.model.SimpleArbitrage(
                    "",
                    "USDT_USDC",
                    "USDT",
                    "/usdt.png",
                    "USDC",
                    "/usdc.png",
                    "SUSHISWAP",
                    "QUICKSWAP",
                    listOf()
                ), com.example.tradebot.model.SimpleArbitrage(
                    "",
                    "USDT_USDC",
                    "USDT",
                    "/usdt.png",
                    "USDC",
                    "/usdc.png",
                    "SUSHISWAP",
                    "QUICKSWAP",
                    listOf()
                ), com.example.tradebot.model.SimpleArbitrage(
                    "",
                    "USDT_USDC",
                    "USDT",
                    "/usdt.png",
                    "USDC",
                    "/usdc.png",
                    "SUSHISWAP",
                    "QUICKSWAP",
                    listOf()
                ), com.example.tradebot.model.SimpleArbitrage(
                    "",
                    "USDT_USDC",
                    "USDT",
                    "/usdt.png",
                    "USDC",
                    "/usdc.png",
                    "SUSHISWAP",
                    "QUICKSWAP",
                    listOf()
                ), com.example.tradebot.model.SimpleArbitrage(
                    "",
                    "USDT_USDC",
                    "USDT",
                    "/usdt.png",
                    "USDC",
                    "/usdc.png",
                    "SUSHISWAP",
                    "QUICKSWAP",
                    listOf()
                ), com.example.tradebot.model.SimpleArbitrage(
                    "",
                    "USDT_USDC",
                    "USDT",
                    "/usdt.png",
                    "USDC",
                    "/usdc.png",
                    "SUSHISWAP",
                    "QUICKSWAP",
                    listOf()
                ), com.example.tradebot.model.SimpleArbitrage(
                    "",
                    "USDT_USDC",
                    "USDT",
                    "/usdt.png",
                    "USDC",
                    "/usdc.png",
                    "SUSHISWAP",
                    "QUICKSWAP",
                    listOf()
                ), com.example.tradebot.model.SimpleArbitrage(
                    "",
                    "USDT_USDC",
                    "USDT",
                    "/usdt.png",
                    "USDC",
                    "/usdc.png",
                    "SUSHISWAP",
                    "QUICKSWAP",
                    listOf()
                ), com.example.tradebot.model.SimpleArbitrage(
                    "",
                    "USDT_USDC",
                    "USDT",
                    "/usdt.png",
                    "USDC",
                    "/usdc.png",
                    "SUSHISWAP",
                    "QUICKSWAP",
                    listOf()
                ), com.example.tradebot.model.SimpleArbitrage(
                    "",
                    "USDT_USDC",
                    "USDT",
                    "/usdt.png",
                    "USDC",
                    "/usdc.png",
                    "SUSHISWAP",
                    "QUICKSWAP",
                    listOf()
                ), com.example.tradebot.model.SimpleArbitrage(
                    "",
                    "USDT_USDC",
                    "USDT",
                    "/usdt.png",
                    "USDC",
                    "/usdc.png",
                    "SUSHISWAP",
                    "QUICKSWAP",
                    listOf()
                ), com.example.tradebot.model.SimpleArbitrage(
                    "",
                    "USDT_USDC",
                    "USDT",
                    "/usdt.png",
                    "USDC",
                    "/usdc.png",
                    "SUSHISWAP",
                    "QUICKSWAP",
                    listOf()
                ), com.example.tradebot.model.SimpleArbitrage(
                    "",
                    "USDT_USDC",
                    "USDT",
                    "/usdt.png",
                    "USDC",
                    "/usdc.png",
                    "SUSHISWAP",
                    "QUICKSWAP",
                    listOf()
                ), com.example.tradebot.model.SimpleArbitrage(
                    "",
                    "USDT_USDC",
                    "USDT",
                    "/usdt.png",
                    "USDC",
                    "/usdc.png",
                    "SUSHISWAP",
                    "QUICKSWAP",
                    listOf()
                )
            )*/


            FlowRow(
                maxItemsInEachRow = 2,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                list.forEach { item ->
                    val percentage : MutableState<String> = remember { mutableStateOf("-") }
                    mSocket.on("simpleArbitrage${item.ID}") { args ->
                        if (args[0] != null && args[1] != null) {
                            val amountIn = args[0] as String
                            val amountOut = args[1] as String
                            percentage.value = percentage(amountIn,amountOut)
                        }
                    }
                    SimpleArbitrageGridItem(percentage,item){
                        navController.currentBackStackEntry?.savedStateHandle?.set(
                            key = "simpleData",
                            value = item
                        )
                        navController.navigate(BottomBarScreen.SimpleDetail.route)
                    }
                }
            }
            Spacer(modifier = Modifier.padding(70.dp))





        }
    }
}


@Preview
@Composable
fun PreviewSimpleArbitrage(){
    SimpleArbitrage(navController = rememberNavController())
}