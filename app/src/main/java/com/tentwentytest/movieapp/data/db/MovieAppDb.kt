package com.tentwentytest.movieapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tentwentytest.movieapp.data.model.movie.Movie
import com.tentwentytest.movieapp.data.model.genre.Genre

@Database(entities = [Movie::class, Genre::class],
        version = 2,
        exportSchema = false
)
abstract class MovieAppDb : RoomDatabase(){
    abstract fun movieDao(): MovieDao
    abstract fun genreDao() : GenreDao
}