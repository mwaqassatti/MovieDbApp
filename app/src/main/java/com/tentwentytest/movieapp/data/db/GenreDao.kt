package com.tentwentytest.movieapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tentwentytest.movieapp.data.model.movie.Movie
import com.tentwentytest.movieapp.data.model.genre.Genre

@Dao
interface GenreDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveGenre(genreList : List<Genre>)

    @Query("DELETE FROM genre")
    suspend fun deleteAllGenre()

    @Query("SELECT * FROM genre")
    suspend fun getGenreList():List<Genre>
}