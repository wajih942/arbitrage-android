package com.example.tradebot.components


import android.speech.tts.TextToSpeech
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tradebot.R
import com.example.tradebot.model.Notification

@Composable
fun NotificationRow(notification : Notification = Notification(R.drawable.usdc,"Sushiswap","Uniswap","ETH/USDT","ETH","USDT","2")){
    Row(modifier = Modifier.padding(10.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
        Image(painter = painterResource(id = notification.image), contentDescription = null, modifier = Modifier.size(width = 50.dp, height = 50.dp))
        Text(text = "An arbitrage opportunity was spotted from ${notification.firstMarket} to ${notification.secondMarket} in the pair ${notification.pair} with a net profit of ${notification.amount} ${notification.token0Name}",
        modifier = Modifier.padding(10.dp), color = Color.White
        )
    }
}


@Preview
@Composable
fun PreviewNotificationRow(){
    NotificationRow()
}