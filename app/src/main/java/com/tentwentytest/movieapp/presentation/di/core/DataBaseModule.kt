package com.tentwentytest.movieapp.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.tentwentytest.movieapp.data.db.GenreDao
import com.tentwentytest.movieapp.data.db.MovieAppDb
import com.tentwentytest.movieapp.data.db.MovieDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun provideMovieDataBase(context: Context):MovieAppDb{
        return Room.databaseBuilder(context,MovieAppDb::class.java,"movieapp")
                .build()
    }
    @Singleton
    @Provides
    fun provideMovieDao(movieAppDb : MovieAppDb): MovieDao {
        return movieAppDb.movieDao()
    }

    @Singleton
    @Provides
    fun provideGenreDao(movieAppDb: MovieAppDb): GenreDao{
        return movieAppDb.genreDao()
    }

}