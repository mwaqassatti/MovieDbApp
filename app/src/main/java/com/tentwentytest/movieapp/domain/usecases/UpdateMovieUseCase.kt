package com.tentwentytest.movieapp.domain.usecases

import com.tentwentytest.movieapp.data.model.movie.Movie
import com.tentwentytest.movieapp.domain.repository.MovieRepository

class UpdateMovieUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute(): List<Movie>? = movieRepository.updateMovies()
}