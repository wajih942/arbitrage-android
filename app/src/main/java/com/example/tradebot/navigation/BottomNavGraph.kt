package com.example.tradebot.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.tradebot.model.SimpleArbitrage
import com.example.tradebot.model.TriangularPath
import com.example.tradebot.model.TriangularPathItem
import com.example.tradebot.screens.BottomBarScreen
import com.example.tradebot.screens.InfoScreen
import com.example.tradebot.screens.MainScreen
import com.example.tradebot.screens.NotificationScreen
import com.example.tradebot.screens.Screen
import com.example.tradebot.screens.SimpleArbitrage
import com.example.tradebot.screens.SimpleDetail
import com.example.tradebot.screens.TriangularArbitrage
import com.example.tradebot.screens.TriangularDetail

@Composable
fun BottomNavGraph(navController: NavHostController){
    NavHost(navController= navController,startDestination = BottomBarScreen.Info.route){
        composable(route = BottomBarScreen.Info.route){
            InfoScreen()
        }
        composable(route = BottomBarScreen.Simple.route){
            SimpleArbitrage(navController = navController)
        }
        composable(route = BottomBarScreen.Triangular.route){
            TriangularArbitrage(navController = navController)
        }
        composable(route = BottomBarScreen.Notification.route){
            NotificationScreen()
        }
        composable(route = BottomBarScreen.SimpleDetail.route
        ){
            val simpleData = navController.previousBackStackEntry?.savedStateHandle?.get<SimpleArbitrage>("simpleData")
            SimpleDetail(simpleData = simpleData ?:SimpleArbitrage("",1,"USDT_USDC","USDT","/usdt.png","USDC","/usdc.png","SUSHISWAP","QUICKSWAP",
                listOf(),
            ),navigationController = navController)
        }
        composable(route = BottomBarScreen.TriangularDetail.route){
            val triangleData = navController.previousBackStackEntry?.savedStateHandle?.get<TriangularPath>("triangleData")

            TriangularDetail(triangleData = triangleData ?:TriangularPath("1","2", listOf(
                TriangularPathItem("","USDT_USDC","USDT","/usdt.png","USDC","/usdc.png"),
                TriangularPathItem("","USDT_USDC","USDT","/usdt.png","USDC","/usdc.png"),
                TriangularPathItem("","USDT_USDC","USDT","/usdt.png","USDC","/usdc.png")
            ),"SUSHISWAP","SUSHISWAP","SUSHISWAP",
                listOf()
            ),navController = navController)
        }
    }
}

