package com.example.tradebot.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tradebot.components.NotificationList


@Composable
fun NotificationScreen(){
    Surface(modifier = Modifier
        .fillMaxSize()
        ,color = Color.Black
    ) {
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier
                .padding(10.dp)
                .verticalScroll(scrollState)
                .fillMaxSize()
        ) {
            Spacer(modifier = Modifier.padding(vertical = 15.dp))
            Text(
                text = "Notifications",
                color = Color.White,
                fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold
            )
            NotificationList()
        }
    }
}

@Preview
@Composable
fun PreviewNotificationScreen(){
    NotificationScreen()
}
