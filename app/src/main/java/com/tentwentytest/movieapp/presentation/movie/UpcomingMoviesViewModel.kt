package com.tentwentytest.movieapp.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.tentwentytest.movieapp.domain.usecases.GetMovieUseCase
import com.tentwentytest.movieapp.domain.usecases.UpdateMovieUseCase

class UpcomingMoviesViewModel(
    private val getMoviesUseCase: GetMovieUseCase,
    private val updateMoviesUsecase: UpdateMovieUseCase
): ViewModel() {

    fun getMovies() = liveData {
        val movieList = getMoviesUseCase.execute()
        emit(movieList)
    }

    fun updateMovies() = liveData {
        val movieList = updateMoviesUsecase.execute()
        emit(movieList)
    }

}