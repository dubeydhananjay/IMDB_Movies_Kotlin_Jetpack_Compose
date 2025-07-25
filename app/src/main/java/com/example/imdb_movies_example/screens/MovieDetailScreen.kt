package com.example.imdb_movies_example.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.imdb_movies_example.viewmodels.MovieDetailViewModel


@Composable
fun MovieDetailScreen() {
    val detailViewModel: MovieDetailViewModel = hiltViewModel()
    val movies = detailViewModel.movies.collectAsState()
    LazyColumn( content = {
        items(movies.value) {
            MovieListItem(movieName = it.name, movieDesc = it.desc)
        }
    } )
}

@Composable
fun MovieListItem(
    movieName: String,
    movieDesc: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        border = BorderStroke(1.dp, Color(0xFFCCCCCC)),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Movie title
            Text(
                text = movieName,
                style = MaterialTheme.typography.h6,
                color = MaterialTheme.colors.onSurface
            )

            // A little breathing room
            Spacer(modifier = Modifier.height(8.dp))

            // Movie description
            Text(
                text = movieDesc,
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.onSurface.copy(alpha = 0.7f)
            )
        }
    }
}
