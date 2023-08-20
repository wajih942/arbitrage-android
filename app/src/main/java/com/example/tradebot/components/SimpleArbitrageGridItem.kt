package com.example.tradebot.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.tradebot.R
import com.example.tradebot.model.SimpleArbitrage
import com.example.tradebot.network.SocketHandler
import java.text.DecimalFormat
import kotlin.math.abs

@Composable
fun SimpleArbitrageGridItem(percentage: MutableState<String> = remember { mutableStateOf("-") },simple:SimpleArbitrage = SimpleArbitrage("",0,"USDT_USDC","USDT","/usdt.png","USDC","/usdc.png","SUSHISWAP","QUICKSWAP",
    listOf(),
),onClick: () -> Unit){

    Box(
        modifier = Modifier
            .padding(20.dp)
            .width(150.dp)
            .height(150.dp).clickable{
                onClick()
            }
            .background(color = Color(0xFF1F1F1F), shape = RoundedCornerShape(25.dp)),
        contentAlignment = Alignment.Center
    ) {

        Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                modifier = Modifier.padding(bottom = 10.dp),
                text = simple.NAME,
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0xFF9C27B0),
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold
            )
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("http://192.168.0.68:8080" + simple.TOKEN0IMAGE)
                        .crossfade(true)
                        .build(),
                    contentDescription = null,
                    //contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(width = 25.dp, height = 25.dp)

                )
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("http://192.168.0.68:8080" + simple.TOKEN1IMAGE)
                        .crossfade(true)
                        .build(),
                    contentDescription = null,
                    //contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(width = 25.dp, height = 25.dp)

                )
            }
            Text(text = percentage.value,modifier = Modifier.padding(vertical = 10.dp),style = MaterialTheme.typography.bodyMedium,
                color = if (percentage.value[0] == '-'){Color.Red}else {
                    Color.Green
                },
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold)
        }
    }
}


@Preview
@Composable
fun PreviewSimpleArbitrageGridItem(){
    SimpleArbitrageGridItem{

    }
}

fun percentage(amountIn : String,amountOut:String): String {
    val entry = amountIn.toDouble()
    val exit = amountOut.toDouble()
    val percentage = (abs(entry - exit) / entry) * 100
    val formattedNumber = DecimalFormat("#.########").format(percentage)
    return if(entry - exit > 0){
        "-$formattedNumber%"
    }else{
        "+$formattedNumber%"
    }
}

fun format(str : String) : String{
    val number = str.toDouble()
    val formatedNumber = DecimalFormat("#.########").format(number)
    return formatedNumber
}