package com.tentwentytest.movieapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tentwentytest.movieapp.data.model.movie.Movie

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies : List<Movie>)

    @Query("DELETE FROM movies")
    suspend fun deleteAllMovies()

    @Query("SELECT * FROM movies")
    suspend fun getMovies():List<Movie>

    @Query("SELECT * FROM movies WHERE id=(:movieId)")
    suspend fun getMoviesDetail(movieId: Int): Movie
}