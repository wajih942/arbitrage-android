package com.example.tradebot.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.tradebot.screens.BottomBarScreen
import com.example.tradebot.screens.FirstScreen
import com.example.tradebot.screens.InfoScreen
import com.example.tradebot.screens.MainScreen
import com.example.tradebot.screens.RegisterScreen
import com.example.tradebot.screens.Screen
import com.example.tradebot.screens.SignInScreen

fun NavGraphBuilder.authNavGraph(navController: NavHostController){
    navigation(startDestination = Screen.First.route, route = "auth") {
        composable(route = Screen.First.route) {
            FirstScreen(navController = navController)
        }
        composable(route = Screen.SignIn.route) {
            SignInScreen(navController = navController)
        }
        composable(route = Screen.register.route) {
            RegisterScreen(navController = navController)
        }
        composable(route = Screen.main.route) {
            MainScreen()
        }

    }
}