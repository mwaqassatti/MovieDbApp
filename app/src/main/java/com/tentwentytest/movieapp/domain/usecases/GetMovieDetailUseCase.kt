package com.tentwentytest.movieapp.domain.usecases

import com.tentwentytest.movieapp.data.model.movie.Movie
import com.tentwentytest.movieapp.domain.repository.MovieRepository

class GetMovieDetailUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute(movieId: Int): Movie =  movieRepository.getMovieDetail(movieId)
}