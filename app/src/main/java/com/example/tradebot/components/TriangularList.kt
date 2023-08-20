package com.example.tradebot.components

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.tradebot.model.TriangularPath
import com.example.tradebot.model.TriangularPathItem
import com.example.tradebot.screens.ArbitrageViewModel
import io.socket.client.Socket

@Composable
fun TriangularList(viewModel: ArbitrageViewModel = hiltViewModel(), triangularList:List<TriangularPath> = listOf(TriangularPath("1","2", listOf(
    TriangularPathItem("","AAAA_USDC","AAAA","/usdt.png","USDC","/usdc.png"),
    TriangularPathItem("","AAAA_USDC","AAAA","/usdt.png","USDC","/usdc.png"),
    TriangularPathItem("","AAAA_USDC","AAAA","/usdt.png","USDC","/usdc.png")
),"SUSHISWAP","SUSHISWAP","SUSHISWAP",
    listOf()),TriangularPath("1","2", listOf(
    TriangularPathItem("","USDT_USDC","USDT","/usdt.png","USDC","/usdc.png"),
    TriangularPathItem("","USDT_USDC","USDT","/usdt.png","USDC","/usdc.png"),
    TriangularPathItem("","USDT_USDC","USDT","/usdt.png","USDC","/usdc.png")
),"SUSHISWAP","SUSHISWAP","SUSHISWAP",
    listOf()),TriangularPath("1","2", listOf(
    TriangularPathItem("","USDT_USDC","USDT","/usdt.png","USDC","/usdc.png"),
    TriangularPathItem("","USDT_USDC","USDT","/usdt.png","USDC","/usdc.png"),
    TriangularPathItem("","USDT_USDC","USDT","/usdt.png","USDC","/usdc.png")
),"SUSHISWAP","SUSHISWAP","SUSHISWAP",
    listOf()),TriangularPath("1","2", listOf(
    TriangularPathItem("","USDT_USDC","USDT","/usdt.png","USDC","/usdc.png"),
    TriangularPathItem("","USDT_USDC","USDT","/usdt.png","USDC","/usdc.png"),
    TriangularPathItem("","USDT_USDC","USDT","/usdt.png","USDC","/usdc.png")
),"SUSHISWAP","SUSHISWAP","SUSHISWAP",
    listOf()),TriangularPath("1","2", listOf(
    TriangularPathItem("","USDT_USDC","USDT","/usdt.png","USDC","/usdc.png"),
    TriangularPathItem("","USDT_USDC","USDT","/usdt.png","USDC","/usdc.png"),
    TriangularPathItem("","USDT_USDC","USDT","/usdt.png","USDC","/usdc.png")
),"SUSHISWAP","SUSHISWAP","SUSHISWAP",
    listOf()),TriangularPath("1","2", listOf(
    TriangularPathItem("","USDT_USDC","USDT","/usdt.png","USDC","/usdc.png"),
    TriangularPathItem("","USDT_USDC","USDT","/usdt.png","USDC","/usdc.png"),
    TriangularPathItem("","USDT_USDC","USDT","/usdt.png","USDC","/usdc.png")
),"SUSHISWAP","SUSHISWAP","SUSHISWAP",
    listOf()),TriangularPath("1","2", listOf(
    TriangularPathItem("","USDT_USDC","USDT","/usdt.png","USDC","/usdc.png"),
    TriangularPathItem("","USDT_USDC","USDT","/usdt.png","USDC","/usdc.png"),
    TriangularPathItem("","USDT_USDC","USDT","/usdt.png","USDC","/usdc.png")
),"SUSHISWAP","SUSHISWAP","SUSHISWAP",
    listOf()),TriangularPath("1","2", listOf(
    TriangularPathItem("","USDT_USDC","USDT","/usdt.png","USDC","/usdc.png"),
    TriangularPathItem("","USDT_USDC","USDT","/usdt.png","USDC","/usdc.png"),
    TriangularPathItem("","USDT_USDC","USDT","/usdt.png","USDC","/usdc.png")
),"SUSHISWAP","SUSHISWAP","SUSHISWAP",
    listOf()),TriangularPath("1","2", listOf(
    TriangularPathItem("","USDT_USDC","USDT","/usdt.png","USDC","/usdc.png"),
    TriangularPathItem("","USDT_USDC","USDT","/usdt.png","USDC","/usdc.png"),
    TriangularPathItem("","USDT_USDC","USDT","/usdt.png","USDC","/usdc.png")
),"SUSHISWAP","SUSHISWAP","SUSHISWAP",
    listOf()),TriangularPath("1","2", listOf(
    TriangularPathItem("","USDT_USDC","USDT","/usdt.png","USDC","/usdc.png"),
    TriangularPathItem("","USDT_USDC","USDT","/usdt.png","USDC","/usdc.png"),
    TriangularPathItem("","USDT_USDC","USDT","/usdt.png","USDC","/usdc.png")
),"SUSHISWAP","SUSHISWAP","SUSHISWAP",
    listOf()),TriangularPath("1","2", listOf(
    TriangularPathItem("","USDT_USDC","USDT","/usdt.png","USDC","/usdc.png"),
    TriangularPathItem("","USDT_USDC","USDT","/usdt.png","USDC","/usdc.png"),
    TriangularPathItem("","USDT_USDC","USDT","/usdt.png","USDC","/usdc.png")
),"SUSHISWAP","SUSHISWAP","SUSHISWAP",
    listOf()),TriangularPath("1","2", listOf(
    TriangularPathItem("","USDT_USDC","USDT","/usdt.png","USDC","/usdc.png"),
    TriangularPathItem("","USDT_USDC","USDT","/usdt.png","USDC","/usdc.png"),
    TriangularPathItem("","USDT_USDC","USDT","/usdt.png","USDC","/usdc.png")
),"SUSHISWAP","SUSHISWAP","SUSHISWAP",
    listOf())),msocket : Socket ,navController: NavController, onClick: (triangle : TriangularPath) -> Unit){
    viewModel.getTriangularPairs()
    val triangularPairs = viewModel.data2.value.data?.toMutableList()
    Log.d("data",triangularPairs.toString())
    Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        triangularPairs?.forEach { triangular ->
            TriangularRow(triangular,msocket){
                onClick(triangular)
            }
        }
    }
}


@Preview
@Composable
fun PreviewTriangularList(){

}