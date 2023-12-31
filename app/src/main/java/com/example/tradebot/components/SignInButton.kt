package com.example.tradebot.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun SignInButton(
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFBF5AF2)),
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .padding(7.dp)
    ) {
        Text(text = "Sign In", color = Color.White,style = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,

        )
        )
    }
}

@Preview
@Composable
fun PreviewSignInButton() {
    SignInButton(onClick = {})
}