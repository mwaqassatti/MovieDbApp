package com.tentwentytest.movieapp.presentation.di.movie

import com.tentwentytest.movieapp.presentation.movie.UpcomingMoviesFragment
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {
    fun inject(upcomingMoviesFragment: UpcomingMoviesFragment)

    @Subcomponent.Factory
    interface Factory{
        fun create():MovieSubComponent
    }
}