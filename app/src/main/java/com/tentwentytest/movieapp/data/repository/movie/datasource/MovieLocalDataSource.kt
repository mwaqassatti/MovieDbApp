package com.tentwentytest.movieapp.data.repository.movie.datasource

import com.tentwentytest.movieapp.data.model.movie.Movie

interface MovieLocalDataSource {
    suspend fun getMoviesFromDB():List<Movie>
    suspend fun saveMoviesToDB(movies:List<Movie>)
    suspend fun clearAll()
    suspend fun getMovieDetailFromDB(movieId: Int) : Movie
}