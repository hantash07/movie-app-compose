package com.hantash.movieapp.navigation

enum class EnumScreens {
    HomeScreen,
    DetailScreen;

    companion object {
        fun fromRoute(route: String?): EnumScreens = when (route?.substringBefore("/")) {
            HomeScreen.name -> HomeScreen
            DetailScreen.name -> DetailScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route is not defined")
        }
    }
}