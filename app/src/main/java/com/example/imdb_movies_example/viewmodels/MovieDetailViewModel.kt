package com.example.imdb_movies_example.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imdb_movies_example.models.MovieListItem
import com.example.imdb_movies_example.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class MovieDetailViewModel @Inject constructor(private val movieRepository: MovieRepository,
    private val savedStateHandle: SavedStateHandle): ViewModel() {
    val movies: StateFlow<List<MovieListItem>>
    get() = movieRepository.movies

    init {
        viewModelScope.launch {
            val category = savedStateHandle.get<String>("category") ?: "horror"
            movieRepository.getMovies(category)
        }
    }
}