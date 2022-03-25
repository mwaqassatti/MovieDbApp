package com.tentwentytest.movieapp.presentation.di.moviedetail

import com.tentwentytest.movieapp.domain.usecases.GetMovieDetailUseCase
import com.tentwentytest.movieapp.presentation.moviedetail.MovieDetailFactoryViewModel
import dagger.Module
import dagger.Provides

@Module
class MovieDetailModule {
    @MovieDetailScope
    @Provides
    fun provideMovieDetailViewModelFactory(movieDetailUseCase: GetMovieDetailUseCase
    ) : MovieDetailFactoryViewModel {
        return MovieDetailFactoryViewModel(movieDetailUseCase)
    }
}