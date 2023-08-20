package com.example.tradebot.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tradebot.screens.BottomBarScreen
import com.example.tradebot.screens.MainScreen
import com.example.tradebot.screens.SimpleArbitrage

@Composable
fun SetupNavGraph(
    navController: NavHostController
){
    NavHost(navController = navController, startDestination = "auth" , route = "route"){
        authNavGraph(navController = navController)
        composable(route = "info"){
            MainScreen()
        }
    }
}