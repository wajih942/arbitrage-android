package com.example.tradebot.screens

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.tradebot.R
import com.example.tradebot.components.RegisterButton
import com.example.tradebot.components.SignInButton

@Composable
fun FirstScreen(navController: NavController){
    Surface(modifier = Modifier.fillMaxSize(),
        color = Color.Black) {
        Column(Modifier.padding(15.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Get Started with the most \nprofitable Arbitrage Bot",
                color = Color.White,
                textAlign = TextAlign.Center,
            style = TextStyle(fontSize = 20.sp,
                fontWeight = FontWeight.Bold)
            )
            Image(
                painter = painterResource(id = R.drawable.getstarted),
                contentDescription = "Image from drawable",
                modifier = Modifier
                    .size(400.dp)
                    .padding(16.dp)
            )
            SignInButton(onClick = {
                navController.navigate(route = Screen.SignIn.route)
            })
            RegisterButton (onClick = {
                navController.navigate(route = Screen.register.route)
            })


        }
    }
}

@Preview
@Composable
fun PreviewFirstScreen(){
    FirstScreen(navController =  rememberNavController())
}