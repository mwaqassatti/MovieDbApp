package com.tentwentytest.movieapp.presentation

import android.app.Application
import com.tentwentytest.movieapp.BuildConfig
import com.tentwentytest.movieapp.presentation.di.Injector
import com.tentwentytest.movieapp.presentation.di.core.*
import com.tentwentytest.movieapp.presentation.di.movie.MovieSubComponent
import com.tentwentytest.movieapp.presentation.di.moviedetail.MovieDetailSubComponent
import javax.inject.Inject

class App : Application(), Injector {
    private lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .networkModule(NetworkModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createMovieDetailSubComponent(): MovieDetailSubComponent {
        return appComponent.movieDetailSubComponent().create()
    }
}