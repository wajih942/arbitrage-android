package com.example.tradebot.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tradebot.R

@Composable
fun DropDownFilter(selectedItem : MutableState<String> = mutableStateOf("Filter")){
    var expanded by remember { mutableStateOf(false) }

    val items = listOf("Option 1", "Option 2", "Option 3")
    //Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
    Box {
        Column {
            TextButton(onClick = { expanded = true }) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                    Icon(Icons.Default.Add, contentDescription = null, tint = Color(0xFF9C27B0))
                    Spacer(modifier = Modifier.padding(2.dp))
                    Text(text = "${selectedItem.value}", fontSize = 15.sp, color = Color(0xFF9C27B0))
                }
            }
            DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }, modifier = Modifier.background(
                Color.Black)) {
                DropdownMenuItem(text = {
                    Text(text = "Max", color = Color.White) },
                    onClick = {
                        selectedItem.value = "Max"
                        expanded = false
                    }, leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowUp,
                            contentDescription = "Arrow Up Icon"
                        )
                    })
                DropdownMenuItem(text = {
                    Text(text = "Min", color = Color.White) },
                    onClick = {
                        selectedItem.value = "Min"
                        expanded = false
                    }, leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowDown,
                            contentDescription = "Arrow Down Icon"
                        )
                    })
            }
        }
    }
}

@Preview
@Composable
fun PreviewDropDownFilter(){
    Surface(modifier = Modifier.fillMaxSize()) {
        DropDownFilter()
    }
}