package com.tentwentytest.movieapp.presentation.moviedetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tentwentytest.movieapp.domain.usecases.GetMovieDetailUseCase

class MovieDetailFactoryViewModel(private val movieDetailUseCase: GetMovieDetailUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieDetailViewModel(movieDetailUseCase) as T
    }
}