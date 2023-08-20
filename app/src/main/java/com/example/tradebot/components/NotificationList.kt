package com.example.tradebot.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.tradebot.R
import com.example.tradebot.model.Notification

@Composable
fun NotificationList(notificationList : List<Notification> = listOf(Notification(R.drawable.usdc,"Sushiswap","Uniswap","ETH/USDT","ETH","USDT","2"),)){
    Column() {
        notificationList.forEach { notification ->
            NotificationRow(notification)
        }
    }
}


@Preview
@Composable
fun PreviewNotificationList(){
    NotificationList()
}