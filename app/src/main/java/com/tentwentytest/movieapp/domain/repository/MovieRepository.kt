package com.tentwentytest.movieapp.domain.repository

import com.tentwentytest.movieapp.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies():List<Movie>?
    suspend fun updateMovies():List<Movie>?
    suspend fun getMovieDetail(movieId: Int):Movie
}