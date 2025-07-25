package com.example.imdb_movies_example.api

import com.example.imdb_movies_example.models.MovieListItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface MoviesApi {

    @GET("v3/b/6840b74a8a456b7966a99180?meta=false")
    suspend fun getMovies(@Header("X-JSON-Path") category: String) : Response<List<MovieListItem>>

    @GET("v3/b/6840b74a8a456b7966a99180?meta=false")
    @Headers("X-JSON-Path:movies..category")
    suspend fun getCategories() : Response<List<String>>
}