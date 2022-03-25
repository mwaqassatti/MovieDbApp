package com.tentwentytest.movieapp.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tentwentytest.movieapp.domain.usecases.GetMovieUseCase
import com.tentwentytest.movieapp.domain.usecases.UpdateMovieUseCase

class UpcomingMoviesFactoryViewModel(
    private val getMoviesUseCase: GetMovieUseCase,
    private val updateMoviesUsecase: UpdateMovieUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UpcomingMoviesViewModel(getMoviesUseCase, updateMoviesUsecase) as T
    }
}