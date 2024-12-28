package com.hantash.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hantash.movieapp.screens.DetailScreen
import com.hantash.movieapp.screens.HomeScreen

@Composable
fun ScreensNavigation() {
    val navController = rememberNavController()
    val defaultScreen = EnumScreens.HomeScreen.name

    NavHost(navController = navController, startDestination = EnumScreens.HomeScreen.name) {
        composable(defaultScreen) {
            HomeScreen(navController)
        }
        composable(EnumScreens.DetailScreen.name) {
            DetailScreen(navController)
        }
    }

}