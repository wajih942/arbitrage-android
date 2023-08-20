package com.example.tradebot.components

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tradebot.model.Token
import com.example.tradebot.screens.ArbitrageViewModel


@Composable
fun TokenList(viewModel: ArbitrageViewModel = hiltViewModel(),tokenList : List<Token> = listOf(Token("11","wmatic",2f,"/wmatic.png"),
    Token("11","usdc",2f,"/usdc.png"),Token("11","weth",2f,"/weth.png"),Token("11","wmatic",2f,"/wmatic.png"))){
    viewModel.getAllQuestions()
    val tokens = viewModel.data.value.data?.toMutableList()
    Log.d("data",tokens.toString())
    Column{
        tokens?.forEach { token ->
            TokenRow(token)
        }
    }
}


@Preview
@Composable
fun PreviewTokenList(){
    //TokenList(viewModel = ArbitrageViewModel)
}