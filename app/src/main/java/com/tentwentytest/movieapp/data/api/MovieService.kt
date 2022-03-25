package com.tentwentytest.movieapp.data.api

import com.tentwentytest.movieapp.data.model.movie.Movie
import com.tentwentytest.movieapp.data.model.movie.MovieList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {

    @GET("upcoming")
    suspend fun getUpComingMovies(@Query("api_key") apiKey : String) : Response<MovieList>

    @GET("{id}")
    suspend fun getMovieDetail(@Path(value="id") movieId : Int, @Query("api_key") apiKey : String) : Response<Movie>
}