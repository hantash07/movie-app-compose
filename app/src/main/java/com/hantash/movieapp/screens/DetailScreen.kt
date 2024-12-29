@file:OptIn(ExperimentalMaterial3Api::class)

package com.hantash.movieapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil3.compose.rememberAsyncImagePainter
import com.hantash.movieapp.model.Movie
import com.hantash.movieapp.model.getMovies
import com.hantash.movieapp.widget.MovieRow

@Composable
fun DetailScreen(navController: NavHostController, movieId: String?) {
    val movieList = getMovies().filter { movie -> movie.id == movieId }
    val movie = movieList.first()
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = movie.title) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back Button",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White
                )
            )
        },
        content = { innerPadding ->
            MovieContent(Modifier.padding(innerPadding), movie)
        }
    )
}

@Composable
fun MovieContent(modifier: Modifier, movie: Movie) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background
    ) {
        Column {
            ImageSlider(movie = movie)
            Spacer(modifier = Modifier.height(8.dp))
            MovieRow(movie = movie)
        }
    }
}

@Composable
fun ImageSlider(movie: Movie) {
    LazyRow {
        items(items = movie.images) { image ->
            Card (
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp)
                    .size(240.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background),
            ) {
                Image(
                    painter = rememberAsyncImagePainter(image),
                    contentDescription = "Movie Image"
                )
            }
        }
    }
}