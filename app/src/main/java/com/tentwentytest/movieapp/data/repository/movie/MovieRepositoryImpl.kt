package com.tentwentytest.movieapp.data.repository.movie

import android.util.Log
import com.tentwentytest.movieapp.data.model.movie.Movie
import com.tentwentytest.movieapp.data.repository.movie.datasource.MovieCacheDataSource
import com.tentwentytest.movieapp.data.repository.movie.datasource.MovieLocalDataSource
import com.tentwentytest.movieapp.data.repository.movie.datasource.MovieRemoteDateSource
import com.tentwentytest.movieapp.domain.repository.MovieRepository
import java.lang.Exception

class MovieRepositoryImpl(private val localDataSource: MovieLocalDataSource,
                          private val remoteDateSource: MovieRemoteDateSource,
                          private val cacheDataSource: MovieCacheDataSource) : MovieRepository {

    private val TAG = MovieRepositoryImpl::class.qualifiedName

    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun getMovieDetail(movieId: Int): Movie {
        return getMovieDetailFromCache(movieId)
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newUpcomingMovieList = getMoviesFromAPI()
        localDataSource.clearAll()
        localDataSource.saveMoviesToDB(newUpcomingMovieList)
        cacheDataSource.saveMoviesToCache(newUpcomingMovieList)
        return newUpcomingMovieList
    }

    suspend fun getMovieDetailFromCache(movieId: Int) : Movie {
        lateinit var movie: Movie
        try {
            movie = cacheDataSource.getMovieDetailFromCache()
        } catch (exception : Exception) {
            Log.i(TAG, exception.message.toString())
        }
        if(movie.id != movieId) {
            movie = getMovieDetailFromDb(movieId)
        } else {
            return movie
        }
        return movie
    }

    suspend fun getMoviesFromCache(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            movieList = cacheDataSource.getMoviesFromCache()
        } catch (exception: Exception) {
            Log.i(TAG, exception.message.toString())
        }
        if (movieList.size>0) {
            return movieList
        } else {
            movieList = getMoviesFromDB()
            cacheDataSource.saveMoviesToCache(movieList)
        }

        return movieList
    }

    suspend fun getMoviesFromDB(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            movieList = localDataSource.getMoviesFromDB()
        } catch (exception: Exception) {
            Log.i(TAG, exception.message.toString())
        }
        if (movieList.size>0) {
            return movieList
        } else {
            movieList = getMoviesFromAPI()
            localDataSource.saveMoviesToDB(movieList)
        }

        return movieList
    }

    suspend fun getMovieDetailFromDb(movieId : Int): Movie {
        lateinit var movie: Movie
        try {
            movie = localDataSource.getMovieDetailFromDB(movieId)
        } catch (exception : Exception) {
            Log.i(TAG, exception.message.toString())
        }
        if(movie.id != movieId) {
            movie = getMovieDetailFromAPI(movieId)
            cacheDataSource.setMovieDetailToCache(movie)
        } else {
            return movie
        }
        return movie
    }

    suspend fun getMoviesFromAPI(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            val response = remoteDateSource.getMovies()
            val body = response.body()
            if (body != null) {
                movieList = body.movies
            }
        } catch (exception: Exception) {
            Log.i(TAG, exception.message.toString())
        }
        return movieList
    }

    suspend fun getMovieDetailFromAPI(movieId: Int) : Movie {
        lateinit var movie : Movie
        try {
            val response = remoteDateSource.getMovieDetail(movieId)
            val body = response.body()
            if(body != null) {
                movie = body
            }
        } catch (exception : Exception) {
            Log.i(TAG, exception.message.toString())
        }
        return movie
    }
}