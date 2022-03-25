package com.tentwentytest.movieapp.presentation.di.core

import com.tentwentytest.movieapp.data.api.MovieService
import com.tentwentytest.movieapp.data.repository.movie.datasource.MovieRemoteDateSource
import com.tentwentytest.movieapp.data.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey : String) {
    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(movieService: MovieService): MovieRemoteDateSource {
        return MovieRemoteDataSourceImpl(
                movieService, apiKey
        )
    }
}