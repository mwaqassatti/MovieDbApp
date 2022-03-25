package com.tentwentytest.movieapp.data.repository.movie.datasource

import com.tentwentytest.movieapp.data.model.movie.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache():List<Movie>
    suspend fun saveMoviesToCache(movies:List<Movie>)
    fun getMovieDetailFromCache():Movie
    fun setMovieDetailToCache(movie: Movie)
}