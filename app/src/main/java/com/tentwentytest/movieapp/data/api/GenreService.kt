package com.tentwentytest.movieapp.data.api

import com.tentwentytest.movieapp.data.model.genre.GenreList
import com.tentwentytest.movieapp.data.model.movie.MovieList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GenreService {

    @GET("genre/movie/list")
    suspend fun getGenresList(@Query("api_key") apiKey : String) : Response<GenreList>
}