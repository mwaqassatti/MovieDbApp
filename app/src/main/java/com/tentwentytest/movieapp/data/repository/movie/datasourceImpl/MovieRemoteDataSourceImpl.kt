package com.tentwentytest.movieapp.data.repository.movie.datasourceImpl

import com.tentwentytest.movieapp.data.api.MovieService
import com.tentwentytest.movieapp.data.model.movie.Movie
import com.tentwentytest.movieapp.data.model.movie.MovieList
import com.tentwentytest.movieapp.data.repository.movie.datasource.MovieRemoteDateSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(private val movieService: MovieService, private val apiKey: String) : MovieRemoteDateSource {

    override suspend fun getMovies(): Response<MovieList> = movieService.getUpComingMovies(apiKey)
    override suspend fun getMovieDetail(movieId: Int): Response<Movie> = movieService.getMovieDetail(movieId, apiKey)
}