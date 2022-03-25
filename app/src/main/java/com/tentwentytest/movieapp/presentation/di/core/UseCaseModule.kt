package com.tentwentytest.movieapp.presentation.di.core

import com.tentwentytest.movieapp.domain.repository.MovieRepository
import com.tentwentytest.movieapp.domain.usecases.GetMovieDetailUseCase
import com.tentwentytest.movieapp.domain.usecases.GetMovieUseCase
import com.tentwentytest.movieapp.domain.usecases.UpdateMovieUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository): GetMovieUseCase {
        return GetMovieUseCase(movieRepository)
    }
    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository): UpdateMovieUseCase {
        return UpdateMovieUseCase(movieRepository)
    }
    @Provides
    fun provideGetMovieDetailUseCase(movieRepository: MovieRepository) : GetMovieDetailUseCase {
        return GetMovieDetailUseCase(movieRepository)
    }
}