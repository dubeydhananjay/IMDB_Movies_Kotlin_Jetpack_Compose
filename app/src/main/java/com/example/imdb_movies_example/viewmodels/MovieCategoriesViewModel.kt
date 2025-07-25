package com.example.imdb_movies_example.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imdb_movies_example.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieCategoriesViewModel @Inject constructor(private val movieRepository: MovieRepository): ViewModel() {
    val categories: StateFlow<List<String>>
    get() = movieRepository.categories

    init {
        viewModelScope.launch {
            movieRepository.getCategories()
        }
    }
}