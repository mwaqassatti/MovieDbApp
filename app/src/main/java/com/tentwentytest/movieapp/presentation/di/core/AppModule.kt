package com.tentwentytest.movieapp.presentation.di.core

import android.content.Context
import com.tentwentytest.movieapp.presentation.di.movie.MovieSubComponent
import com.tentwentytest.movieapp.presentation.di.moviedetail.MovieDetailSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [MovieSubComponent::class,MovieDetailSubComponent::class])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext(): Context {
        return context.applicationContext
    }
}