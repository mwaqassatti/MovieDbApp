package com.tentwentytest.movieapp.presentation.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tentwentytest.movieapp.R
import com.tentwentytest.movieapp.data.model.movie.Movie
import com.tentwentytest.movieapp.databinding.ListItemMovieBinding
import com.tentwentytest.movieapp.utils.Constant

class UpcomingMovieAdapter() :
    RecyclerView.Adapter<UpcomingMovieAdapter.UpcomingMovieViewHolder>() {

    private val movieList = ArrayList<Movie>()
    var onItemClick: ((Movie) -> Unit)? = null

    fun setList(movies:List<Movie>){
        movieList.clear()
        movieList.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingMovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ListItemMovieBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item_movie,
            parent,
            false
        )
        return UpcomingMovieViewHolder(binding, onItemClick)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: UpcomingMovieViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    inner class UpcomingMovieViewHolder(private val listItemMovieBinding: ListItemMovieBinding,private var onItemClick: ((Movie) -> Unit)?) :
        RecyclerView.ViewHolder(listItemMovieBinding.root) {

        fun bind(movie: Movie) {
            listItemMovieBinding.tvMovieTitle.text = movie.title
            val posterURL = Constant.BASE_URL_POSTER_W5000 + movie.backdrop_path
            Glide.with(listItemMovieBinding.imgMoviePoster.context)
                .load(posterURL)
                .into(listItemMovieBinding.imgMoviePoster)
            listItemMovieBinding.root.setOnClickListener {
                onItemClickListener?.let {
                    it(movie)
                }
            }
        }
    }

    private var onItemClickListener :((Movie)->Unit)?=null

    fun setOnItemClickListener(listener : (Movie)->Unit){
        onItemClickListener = listener
    }
}