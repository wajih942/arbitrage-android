package com.example.tradebot.screens

sealed class Screen(val route:String){
    object  First : Screen("first")
    object SignIn : Screen(route = "signin")
    object register : Screen(route = "register")
    object main : Screen(route = "main")
}
