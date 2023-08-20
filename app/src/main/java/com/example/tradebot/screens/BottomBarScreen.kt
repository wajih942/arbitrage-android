package com.example.tradebot.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Info : BottomBarScreen(
        route = "info",
        title = "info",
        icon = Icons.Default.Home
    )

    object Simple : BottomBarScreen(
        route = "simple",
        title = "simple",
        icon = Icons.Default.Person
    )

    object Triangular : BottomBarScreen(
        route = "triangular",
        title = "triangular",
        icon = Icons.Default.Settings
    )

    object Notification : BottomBarScreen(
        route = "notification",
        title = "Settings",
        icon = Icons.Default.Settings
    )
    object SimpleDetail : BottomBarScreen(
        route = "simpleDetail",
        title = "simpleDetail",
        icon = Icons.Default.Settings
    )
    object TriangularDetail : BottomBarScreen(
        route = "triangularDetail",
        title = "triangularDetail",
        icon = Icons.Default.Settings
    )
}