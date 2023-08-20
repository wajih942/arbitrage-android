package com.example.tradebot.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownMenuExample(dropDownInput: String = "First Market",selectedItem : MutableState<String> = mutableStateOf("First Market")) {
    var expanded by remember { mutableStateOf(false) }
    //var selectedItem by remember { mutableStateOf(dropDownInput) }
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
                        Text(text = "Uniswap", color = Color.White) },
                        onClick = {
                            selectedItem.value = "UNISWAP"
                            expanded = false
                        }, leadingIcon = {
                            Image(painter = painterResource(R.drawable.uniswap), contentDescription = null, modifier = Modifier.size(height = 30.dp, width = 30.dp))
                        })
                    DropdownMenuItem(text = {
                        Text(text = "Sushiswap", color = Color.White) },
                        onClick = {
                            selectedItem.value = "SUSHISWAP"
                            expanded = false
                        }, leadingIcon = {
                            Image(painter = painterResource(R.drawable.sushiswap), contentDescription = null, modifier = Modifier.size(height = 30.dp, width = 30.dp))
                        })
                    DropdownMenuItem(text = {
                        Text(text = "Quickswap", color = Color.White) },
                        onClick = {
                            selectedItem.value = "QUICKSWAP"
                            expanded = false
                        }, leadingIcon = {
                            Image(painter = painterResource(R.drawable.quickswap), contentDescription = null, modifier = Modifier.size(height = 30.dp, width = 30.dp))
                        })
                }
            }
        }
    //}

}

@Preview(showBackground = true)
@Composable
fun PreviewDropDownMenu(){
    Surface(modifier = Modifier.fillMaxSize()) {
        DropdownMenuExample()
    }
}
