package com.example.tradebot.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tradebot.R
import com.example.tradebot.network.SocketHandler
import com.example.tradebot.screens.SocketViewModel

@Composable
fun BlockNumber(){

    // The following lines connects the Android app to the server.
    SocketHandler.setSocket()
    SocketHandler.establishConnection()
    val mSocket = SocketHandler.getSocket()
    val newBlockData: MutableState<Int> = remember { mutableStateOf(0) }
    // args[0] is the data from the server
    // Change "as Int" according to the data type
    // Example "as String" or write nothing
    // Logging the data is optional
    mSocket.on("blockNumber") { args ->
        if (args[0] != null) {
            val counter = args[0] as Int
            newBlockData.value = counter
        }
    }
    Box(
        modifier = Modifier
            .padding(10.dp)
            .width(130.dp)
            .height(130.dp)
            .background(color = Color(0xFF1F1F1F), shape = RoundedCornerShape(25.dp)),
        contentAlignment = Alignment.Center
    ) {
        Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                modifier = Modifier.padding(bottom = 5.dp),
                text = "Block Number",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = newBlockData.value.toString(),
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )


        }
    }
}


@Preview
@Composable
fun PreviewBlockNumber(){
    BlockNumber()
}