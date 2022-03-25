package com.tentwentytest.movieapp.presentation.di.moviedetail

import com.tentwentytest.movieapp.presentation.moviedetail.MovieDetailActivity
import dagger.Subcomponent

@MovieDetailScope
@Subcomponent(modules = [MovieDetailModule::class])
interface MovieDetailSubComponent {
    fun inject(movieDetailActivity: MovieDetailActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): MovieDetailSubComponent
    }
}