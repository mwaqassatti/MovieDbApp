package com.tentwentytest.movieapp.presentation.di.core

import com.tentwentytest.movieapp.presentation.di.movie.MovieSubComponent
import com.tentwentytest.movieapp.presentation.di.moviedetail.MovieDetailSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    NetworkModule::class,
    DataBaseModule::class,
    UseCaseModule::class,
    RepositoryModule::class,
    RemoteDataModule::class,
    LocalDataModule::class,
    CacheDataModule::class
])
interface AppComponent {
    fun movieSubComponent(): MovieSubComponent.Factory
    fun movieDetailSubComponent(): MovieDetailSubComponent.Factory
}