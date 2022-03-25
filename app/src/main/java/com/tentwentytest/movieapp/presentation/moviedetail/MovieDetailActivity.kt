package com.tentwentytest.movieapp.presentation.moviedetail

import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.tentwentytest.movieapp.R
import com.tentwentytest.movieapp.databinding.ActivityMovieDetailBinding
import com.tentwentytest.movieapp.presentation.di.Injector
import com.tentwentytest.movieapp.utils.Constant
import java.text.SimpleDateFormat
import javax.inject.Inject

class MovieDetailActivity : AppCompatActivity(){

    @Inject
    lateinit var factory : MovieDetailFactoryViewModel
    private lateinit var movieDetailViewModel: MovieDetailViewModel
    private lateinit var binding : ActivityMovieDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_detail)
        (application as Injector).createMovieDetailSubComponent().inject(this)
        movieDetailViewModel = ViewModelProvider(this, factory).get(MovieDetailViewModel::class.java)

        setFullScreen()
        getData()
    }

    private fun getData() {
        val bundle :Bundle ?=intent.extras
        val movieId = bundle!!.getInt(Constant.KEY_MOVIE_ID)
        val responseLiveData = movieDetailViewModel.getMovieDetail(movieId)
        responseLiveData.observe(this) {
            if (it != null) {
                val parser = SimpleDateFormat("yyyy-mm-dd")
                val formatter = SimpleDateFormat("MMMM dd, yyyy")
                val date: String = formatter.format(parser.parse(it.release_date))
                binding.tvReleaseDate.text = String.format(getString(R.string.watch_in_teaters), date)
                binding.tvOverview.text = it.overview
                Glide.with(binding.imgMovieDetailPoster.context)
                    .load(Constant.BASE_URL_POSTER_W5000+it.poster_path)
                    .into(binding.imgMovieDetailPoster)
            }
        }
    }

    private fun setFullScreen() {

        val window: Window = window
        val winParams: WindowManager.LayoutParams = window.getAttributes()
        winParams.flags =
            winParams.flags and WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS.inv()
        window.setAttributes(winParams)
        window.getDecorView()
            .setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
    }
}