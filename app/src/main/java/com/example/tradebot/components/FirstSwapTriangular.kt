package com.example.tradebot.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.tradebot.model.TriangularPath
import com.example.tradebot.model.TriangularPathItem

@Composable
fun FirstSwapTriangular(triangular: TriangularPath = TriangularPath("1","2", listOf(
    TriangularPathItem("","USDT_USDC","USDT","/usdt.png","USDC","/usdc.png"),
    TriangularPathItem("","USDT_USDC","USDT","/usdt.png","USDC","/usdc.png"),
    TriangularPathItem("","USDT_USDC","USDT","/usdt.png","USDC","/usdc.png")
),"SUSHISWAP","SUSHISWAP","SUSHISWAP",
    listOf()),amountIn : String = "1",firstSwap : String = "1.22"){
    Box(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .height(250.dp)
            .background(color = Color(0xFF1F1F1F), shape = RoundedCornerShape(25.dp)),
        contentAlignment = Alignment.Center
    ){
        Column(Modifier.fillMaxWidth()) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End) {
                Text(text = triangular.FIRSTMARKET, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                Spacer(modifier = Modifier.padding(5.dp))
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("http://192.168.0.68:8080/" + triangular.FIRSTMARKET.toLowerCase() + ".png")
                        .crossfade(true)
                        .build(),
                    contentDescription = null,
                    //contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(width = 25.dp, height = 25.dp)

                )
            }
            Row(modifier = Modifier.padding(15.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                Text(text = "Amount In", color = Color.White, fontSize = 12.sp, modifier = Modifier.width(80.dp))
                Spacer(modifier = Modifier.padding(horizontal = 15.dp))
                Box(
                    modifier = Modifier
                        .width(130.dp)
                        .height(40.dp)
                        .background(color = Color(0xFF3A3A3A), shape = RoundedCornerShape(25.dp)),
                    contentAlignment = Alignment.Center
                ){
                    Text(text = amountIn, color = Color.White, fontSize = 12.sp, modifier = Modifier.width(80.dp),textAlign = TextAlign.Center,)
                }

                Text(text = triangular.tiangularPath[0].TOKEN0NAME, color = Color.White, fontSize = 12.sp, modifier = Modifier.width(80.dp).padding(horizontal = 3.dp),textAlign = TextAlign.End,)
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("http://192.168.0.68:8080" + triangular.tiangularPath[0].TOKEN0IMAGE)
                        .crossfade(true)
                        .build(),
                    contentDescription = null,
                    //contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(width = 25.dp, height = 25.dp)

                )
            }
            Row(modifier = Modifier.padding(15.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                Text(text = "Amount Out", color = Color.White, fontSize = 12.sp, modifier = Modifier.width(80.dp))
                Spacer(modifier = Modifier.padding(horizontal = 15.dp))
                Box(
                    modifier = Modifier
                        .width(130.dp)
                        .height(40.dp)
                        .background(color = Color(0xFF3A3A3A), shape = RoundedCornerShape(25.dp)),
                    contentAlignment = Alignment.Center
                ){
                    Text(text = firstSwap, color = Color.White, fontSize = 12.sp, modifier = Modifier.width(80.dp),textAlign = TextAlign.Center,)
                }

                Text(text = triangular.tiangularPath[0].TOKEN1NAME, color = Color.White, fontSize = 12.sp, modifier = Modifier.width(80.dp).padding(horizontal = 3.dp),textAlign = TextAlign.End,)
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("http://192.168.0.68:8080" + triangular.tiangularPath[0].TOKEN1IMAGE)
                        .crossfade(true)
                        .build(),
                    contentDescription = null,
                    //contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(width = 25.dp, height = 25.dp)

                )
            }
        }
    }
}


@Preview
@Composable
fun PreviewFirstSwapTriangular(){
    FirstSwapTriangular()
}