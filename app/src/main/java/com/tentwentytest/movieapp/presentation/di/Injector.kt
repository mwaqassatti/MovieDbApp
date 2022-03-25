package com.tentwentytest.movieapp.presentation.di

import com.tentwentytest.movieapp.presentation.di.movie.MovieSubComponent
import com.tentwentytest.movieapp.presentation.di.moviedetail.MovieDetailSubComponent

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
    fun createMovieDetailSubComponent() : MovieDetailSubComponent
}