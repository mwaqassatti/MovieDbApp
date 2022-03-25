package com.tentwentytest.movieapp.data.repository.movie.datasource

import com.tentwentytest.movieapp.data.model.movie.Movie
import com.tentwentytest.movieapp.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDateSource {
    suspend fun getMovies(): Response<MovieList>
    suspend fun getMovieDetail(movieId: Int) : Response<Movie>
}