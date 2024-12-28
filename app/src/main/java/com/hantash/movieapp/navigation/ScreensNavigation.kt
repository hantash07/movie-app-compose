package com.hantash.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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

        composable(
            route = EnumScreens.DetailScreen.name + "/{movie}",
            arguments = listOf(navArgument(name = "movie") {type = NavType.StringType})
        ) { backStackEntry ->
            DetailScreen(navController =  navController, backStackEntry.arguments?.getString("movie"))
        }

    }

}