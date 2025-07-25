package com.example.imdb_movies_example.repository

import com.example.imdb_movies_example.api.MoviesApi
import com.example.imdb_movies_example.models.MovieListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class MovieRepository @Inject constructor(private val movieApi: MoviesApi){

    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categories: StateFlow<List<String>>
    get() = _categories

    private val _movies = MutableStateFlow<List<MovieListItem>>(emptyList())
    val movies: StateFlow<List<MovieListItem>>
        get() = _movies

    suspend fun getCategories() {
        val response = movieApi.getCategories()
        if(response.isSuccessful && response.body() != null) {
            _categories.emit(response.body()!!)
        }
    }

    suspend fun getMovies(category: String) {
        val response = movieApi.getMovies("movies[?(@.category==\"$category\")]")
        if(response.isSuccessful && response.body() != null) {
            _movies.emit(response.body()!!)
        }
    }
}