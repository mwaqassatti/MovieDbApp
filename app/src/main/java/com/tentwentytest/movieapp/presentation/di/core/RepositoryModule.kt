package com.tentwentytest.movieapp.presentation.di.core

import com.tentwentytest.movieapp.data.repository.movie.MovieRepositoryImpl
import com.tentwentytest.movieapp.data.repository.movie.datasource.MovieCacheDataSource
import com.tentwentytest.movieapp.data.repository.movie.datasource.MovieLocalDataSource
import com.tentwentytest.movieapp.data.repository.movie.datasource.MovieRemoteDateSource
import com.tentwentytest.movieapp.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(
            movieRemoteDatasource: MovieRemoteDateSource,
            movieLocalDataSource: MovieLocalDataSource,
            movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {

        return MovieRepositoryImpl(
                movieLocalDataSource,
                movieRemoteDatasource,
                movieCacheDataSource
        )


    }

}