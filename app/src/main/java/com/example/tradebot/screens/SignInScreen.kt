package com.example.tradebot.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.tradebot.components.EmailTextField
import com.example.tradebot.components.PasswordTextField
import com.example.tradebot.components.ReturnButton
import com.example.tradebot.components.SignInButton

@Composable
fun SignInScreen(navController: NavController){
    Surface(Modifier.fillMaxSize(), color = Color.Black) {
        Row(horizontalArrangement = Arrangement.Start, modifier = Modifier.fillMaxWidth()) {
            ReturnButton {
                navController.popBackStack()
            }
        }
        Column(Modifier.padding(10.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Sign In",
                color = Color(0xFFBF5AF2),
                textAlign = TextAlign.Center,
                style = TextStyle(fontSize = 30.sp,
                    fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(bottom = 10.dp)
            )
            EmailTextField()
            PasswordTextField()
            Column(modifier = Modifier.padding(10.dp)) {
                SignInButton(onClick = {
                    navController.navigate(BottomBarScreen.Info.route){
                        popUpTo("auth"){
                            inclusive = true
                        }
                    }
                })
                Spacer(modifier = Modifier.padding(2.dp))
                Row(horizontalArrangement = Arrangement.End, verticalAlignment = Alignment.CenterVertically) {
                    Spacer(modifier = Modifier.padding(horizontal = 100.dp))
                    Text(text = "Forget Password",
                        color = Color(0xFFBF5AF2),
                        textAlign = TextAlign.Center,
                        style = TextStyle(fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold),
                        modifier = Modifier.padding(bottom = 10.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewSignInScreen(){
    SignInScreen(navController = rememberNavController())
}