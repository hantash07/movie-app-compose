package com.hantash.movieapp.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.hantash.movieapp.model.getMovies
import com.hantash.movieapp.navigation.EnumScreens
import com.hantash.movieapp.widget.MovieRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Favorite Movies") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White
                )
            )
        },
        content = { innerPadding ->
            MainContent(Modifier.padding(innerPadding), navController)
        }
    )
}

@Composable
fun MainContent(modifier: Modifier, navController: NavController) {
    val movieList = getMovies()
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background
    ) {
        LazyColumn {
            items(items = movieList) { movie ->
                MovieRow(movie, onItemClick = {
                    navController.navigate(route = EnumScreens.DetailScreen.name + "/${movie.title}")
                })
            }
        }
    }
}