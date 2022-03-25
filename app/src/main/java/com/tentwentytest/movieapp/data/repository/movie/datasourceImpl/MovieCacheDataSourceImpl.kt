package com.tentwentytest.movieapp.data.repository.movie.datasourceImpl

import com.tentwentytest.movieapp.data.model.movie.Movie
import com.tentwentytest.movieapp.data.repository.movie.datasource.MovieCacheDataSource

class MovieCacheDataSourceImpl : MovieCacheDataSource {

    private var movieList = ArrayList<Movie>()
    private var movie: Movie = Movie()
    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }

    override fun getMovieDetailFromCache(): Movie {
        return movie
    }

    override fun setMovieDetailToCache(movie: Movie) {
        this.movie = movie
    }
}