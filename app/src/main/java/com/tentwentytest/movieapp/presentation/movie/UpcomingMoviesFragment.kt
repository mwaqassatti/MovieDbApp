package com.tentwentytest.movieapp.presentation.movie

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.tentwentytest.movieapp.R
import com.tentwentytest.movieapp.data.model.movie.Movie
import com.tentwentytest.movieapp.databinding.FragmentUpcomingMoviesBinding
import com.tentwentytest.movieapp.presentation.di.Injector
import com.tentwentytest.movieapp.presentation.moviedetail.MovieDetailActivity
import com.tentwentytest.movieapp.utils.Constant
import javax.inject.Inject

class UpcomingMoviesFragment : Fragment(){

    @Inject
    lateinit var factory : UpcomingMoviesFactoryViewModel
    private lateinit var upcomingMoviesViewModel: UpcomingMoviesViewModel
    private lateinit var binding : FragmentUpcomingMoviesBinding
    private lateinit var adapter : UpcomingMovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (requireContext().applicationContext as Injector).createMovieSubComponent()
            .inject(this)
        upcomingMoviesViewModel = ViewModelProvider(this, factory).get(UpcomingMoviesViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_upcoming_movies, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView(){
        binding.recyclerViewUpComingMovies.layoutManager = LinearLayoutManager(context)
        adapter = UpcomingMovieAdapter()
        binding.recyclerViewUpComingMovies.adapter = adapter
        displayUpcomingMovies()
        adapter.setOnItemClickListener {
            openMovieDetailActivity(it)
        }
    }

    private fun displayUpcomingMovies() {
        binding.movieProgressBar.visibility = View.VISIBLE
        val responseLiveData = upcomingMoviesViewModel.getMovies()
        responseLiveData.observe(viewLifecycleOwner, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility = View.GONE
            }else{
                binding.movieProgressBar.visibility = View.GONE
                Toast.makeText(context,getString(R.string.no_movie_available), Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun openMovieDetailActivity(movie: Movie) {
        val intent = Intent(requireContext(), MovieDetailActivity::class.java)
        intent.putExtra(Constant.KEY_MOVIE_ID, movie.id)
        startActivity(intent)
    }

}