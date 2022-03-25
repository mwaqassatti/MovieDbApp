package com.tentwentytest.movieapp.presentation.di.core

import com.tentwentytest.movieapp.data.repository.movie.datasource.MovieCacheDataSource
import com.tentwentytest.movieapp.data.repository.movie.datasourceImpl.MovieCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }
}