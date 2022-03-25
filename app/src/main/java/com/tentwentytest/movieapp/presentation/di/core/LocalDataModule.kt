package com.tentwentytest.movieapp.presentation.di.core

import com.tentwentytest.movieapp.data.db.MovieDao
import com.tentwentytest.movieapp.data.repository.movie.datasource.MovieLocalDataSource
import com.tentwentytest.movieapp.data.repository.movie.datasourceImpl.MovieLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {
    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }
}
