package com.example.tradebot.screens

import android.widget.ScrollView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tradebot.components.BlockNumber
import com.example.tradebot.components.BurgerButton
import com.example.tradebot.components.ImageSlider
import com.example.tradebot.components.NetworkCard
import com.example.tradebot.components.TokenList
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@Composable
fun InfoScreen(){
    Surface(modifier = Modifier
        .fillMaxSize()
        ,color = Color.Black
    ) {

        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .padding(10.dp)
        ) {
            Row() {
                Text(text = "Home",fontSize = 40.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White)
                Spacer(modifier = Modifier.width(200.dp))
                BurgerButton {

                }

            }
            ImageSlider()

            Text(text = "Info",fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White, modifier = Modifier.padding(start = 20.dp, bottom = 10.dp))
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center, modifier = Modifier
                .fillMaxWidth()
                .padding()) {
                NetworkCard()
                BlockNumber()
            }

            Text(text = "Our Tokens",fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White, modifier = Modifier.padding(20.dp))

            TokenList()
            Spacer(modifier = Modifier.padding(vertical = 60.dp))
        }
    }
}



@Preview
@Composable
fun PreviewInfoScreen(){
    InfoScreen()
}