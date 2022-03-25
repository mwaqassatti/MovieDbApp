package com.tentwentytest.movieapp.presentation.moviedetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.tentwentytest.movieapp.domain.usecases.GetMovieDetailUseCase

class MovieDetailViewModel(private val movieDetailUseCase: GetMovieDetailUseCase) : ViewModel() {

    fun getMovieDetail(movieId: Int) = liveData {
        val movieList = movieDetailUseCase.execute(movieId)
        emit(movieList)
    }
}