package com.example.tradebot.components

import android.graphics.fonts.FontStyle
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.Indication
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tradebot.R
import kotlinx.coroutines.delay


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImageSlider(){
    var text = listOf("Every Arbitrage Opportunities is Automated","We Are Able To Scan 24/7","We Are Scanning Many Decentralized Exchanges")
    val Images = listOf(R.drawable.im1,R.drawable.im2,R.drawable.im3)
    val pagerState = rememberPagerState()
    Column(modifier = Modifier
        .fillMaxWidth()
        .height(300.dp)) {
        Box(modifier = Modifier.fillMaxSize()){
            Column(modifier = Modifier.fillMaxWidth().height(270.dp), verticalArrangement = Arrangement.Center,Alignment.CenterHorizontally) {
                HorizontalPager(pageCount = Images.size,
                    state = pagerState,
                    key = {Images[it]}
                ){ index ->
                    Column(modifier = Modifier.padding(10.dp).height(230.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = text[index], fontSize = 20.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White
                        )
                        Image(painter = painterResource(id = Images[index]), contentDescription = null, contentScale = ContentScale.Crop, modifier = if(index == 2) Modifier.size(width = 130.dp, height = 130.dp) else Modifier.size(width = 150.dp, height = 150.dp))


                    }
                }
                Log.d("eee",pagerState.currentPage.toString())
                Row() {
                    Images.forEachIndexed{index1,i ->
                        Indicator(active = index1 == pagerState.currentPage)
                        if(index1 < Images.size - 1){
                            Spacer(modifier = Modifier.width(5.dp))
                        }
                    }
                }
            }
        }



    }
}


@Composable
fun Indicator(active:Boolean){
    val color = if (active) Color.White else Color.Gray
    val size = if (active) 10.dp else 10.dp
    Box(modifier = Modifier
        .clip(CircleShape)
        .background(color = color)
        .size(size = size))
}

@Preview
@Composable
fun PreviewImageSlider(){
    ImageSlider()
}
/*
@Composable
fun ImageSlider(){
    val Images = listOf(R.drawable.im1,R.drawable.im2,R.drawable.im3)
    ImageSliderWithIndicator(images = Images)
}

@Composable
fun ImageSliderItem(imageRes:Int){
    Image(painter = painterResource(id = imageRes), contentDescription = null, contentScale = ContentScale.Crop,
    modifier = Modifier
        .fillMaxWidth()
        .height(200.dp))
}


@Composable
fun Indicator(active:Boolean){
    val color = if (active) Color.White else Color.Black
    val size = if (active) 10.dp else 10.dp
    Box(modifier = Modifier
        .clip(CircleShape)
        .background(color = color)
        .size(size = size))
}

@Composable
fun ImageSliderWithIndicator(images: List<Int>){
    val currentIndex = remember {
        mutableStateOf(0)
    }
    
    LaunchedEffect(Unit){
        while (true){
            delay(3000)
            currentIndex.value = (currentIndex.value + 1) % images.size
        }
    }
    
    Column(modifier = Modifier.fillMaxWidth()) {
        Box(modifier = Modifier
            .padding(top = 10.dp)
            .weight(1f)) {
            ImageSliderItem(imageRes = images[currentIndex.value])
        }
        Row(modifier = Modifier.padding(start = 170.dp, bottom = 550.dp)) {
            images.forEachIndexed{index,i ->
                Indicator(active = index == currentIndex.value)
                if(index < images.size - 1){
                    Spacer(modifier = Modifier.width(5.dp))
                }
            }
        }
    }
}
*/
