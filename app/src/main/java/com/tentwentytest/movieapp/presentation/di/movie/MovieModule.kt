package com.tentwentytest.movieapp.presentation.di.movie

import com.tentwentytest.movieapp.domain.usecases.GetMovieUseCase
import com.tentwentytest.movieapp.domain.usecases.UpdateMovieUseCase
import com.tentwentytest.movieapp.presentation.movie.UpcomingMoviesFactoryViewModel
import dagger.Module
import dagger.Provides

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMovieUseCase,
        updateMoviesUsecase: UpdateMovieUseCase
    ): UpcomingMoviesFactoryViewModel {
        return UpcomingMoviesFactoryViewModel(
            getMoviesUseCase,
            updateMoviesUsecase
        )
    }

}