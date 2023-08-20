package com.example.tradebot.screens

import android.annotation.SuppressLint
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.tradebot.components.DropDownFilter
import com.example.tradebot.components.DropdownMenuExample
import com.example.tradebot.components.ResetButton
import com.example.tradebot.components.SearchButton
import com.example.tradebot.components.TriangularList
import com.example.tradebot.network.SocketHandler

@SuppressLint("UnrememberedMutableState")
@Composable
fun TriangularArbitrage(navController: NavController) {
    var first = mutableStateOf("First Market")
    var second = mutableStateOf("Second Market")
    var third = mutableStateOf("Third Market")
    var sort = mutableStateOf("Sort")
    SocketHandler.setSocket()
    SocketHandler.establishConnection()
    val mSocket = SocketHandler.getSocket()
    Surface(
        modifier = Modifier
            .fillMaxSize(), color = Color.Black
    ) {
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier
                .padding(5.dp)
                .verticalScroll(scrollState)
                .fillMaxSize()
        ) {
            Spacer(modifier = Modifier.padding(vertical = 15.dp))
            Text(
                text = "Triangular Arbitrage",
                color = Color.White,
                fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold
            )
            Spacer(modifier = Modifier.padding(vertical = 15.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 3.dp)
            ) {
                Text(
                    text = "Choose The First Market",
                    color = Color.White,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.width(220.dp)
                )

                Row(modifier = Modifier.width(300.dp), horizontalArrangement = Arrangement.End) {
                    DropdownMenuExample(selectedItem = first)
                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 3.dp)
            ) {
                Text(
                    text = "Choose The Second Market",
                    color = Color.White,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.width(220.dp)
                )

                Row(modifier = Modifier.width(300.dp), horizontalArrangement = Arrangement.End) {
                    DropdownMenuExample(selectedItem = second)
                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 3.dp)
            ) {
                Text(
                    text = "Choose The Third Market",
                    color = Color.White,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.width(220.dp)
                )

                Row(modifier = Modifier.width(300.dp), horizontalArrangement = Arrangement.End) {
                    DropdownMenuExample(selectedItem = third)
                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 3.dp)
            ) {
                Text(
                    text = "Filter By Arbitrage opportunity",
                    color = Color.White,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.width(220.dp)
                )

                Row(modifier = Modifier.width(300.dp), horizontalArrangement = Arrangement.End) {
                    DropDownFilter(selectedItem = sort)
                }
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .fillMaxWidth()
            ) {
                SearchButton {

                }
                Spacer(modifier = Modifier.padding(horizontal = 10.dp))
                ResetButton {

                }
            }
            TriangularList(navController = navController, msocket = mSocket) { triangular ->
                navController.currentBackStackEntry?.savedStateHandle?.set(
                    key = "triangleData",
                    value = triangular
                )
                navController.navigate(BottomBarScreen.TriangularDetail.route)
            }
            Spacer(modifier = Modifier.padding(60.dp))
        }
    }
}
@Preview
@Composable
fun PreviewTriangularArbitrage(){
    TriangularArbitrage(navController = rememberNavController())
}