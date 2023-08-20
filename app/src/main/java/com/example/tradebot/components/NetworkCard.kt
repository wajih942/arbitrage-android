package com.example.tradebot.components

import androidx.compose.foundation.Image
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tradebot.R

@Composable
fun NetworkCard(){
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
                modifier = Modifier.padding(bottom = 10.dp),
                text = "Network",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                Text(
                    modifier = Modifier.padding(5.dp),
                    text = "Polygon",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.White,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold
                )

                Image(painter = painterResource(id = R.drawable.polygon), contentDescription = null, contentScale = ContentScale.Crop, modifier = Modifier.size(width = 25.dp, height = 25.dp))
            }
        }
    }
}

@Preview
@Composable
fun PreviewNetworkCard(){
    NetworkCard()
}