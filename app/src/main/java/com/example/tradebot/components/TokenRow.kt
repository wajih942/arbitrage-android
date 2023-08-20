package com.example.tradebot.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.tradebot.model.Token


@Composable
fun TokenRow(token: Token = Token("11","wmatic",2f,"/wmatic.png")){
    Row(
        Modifier
            .padding(10.dp)
            .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
        Row(Modifier.width(100.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
            Text(text = token.name, color = Color.White, fontSize = 15.sp)
        }

        Row(Modifier.width(200.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
            Text(text = "Amount : ", color = Color.White, fontSize = 15.sp)
            Text(text = " ${token.amount}", color = Color.Green, fontSize = 15.sp)
        }


        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("http://192.168.0.68:8080" + token.image)
                .crossfade(true)
                .build(),
            contentDescription = null,
            //contentScale = ContentScale.Crop,
            modifier = Modifier.size(width = 35.dp, height = 35.dp).padding(end = 10.dp)
        )
    }
}

@Preview
@Composable
fun PreviewTokenRow(){
    TokenRow()
}