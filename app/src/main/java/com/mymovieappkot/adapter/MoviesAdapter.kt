package com.mymovieappkot.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mymovieappkot.model.Movies
import com.mymovieappkot.R
import com.mymovieappkot.databinding.RecyclerviewMovieBinding

class MoviesAdapter (
private val movies:List<Movies>
):RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
        MoviesViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.recyclerview_movie,
                parent,
                false
            )
        )

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.recyclerviewMovieBinding.movie=movies[position]

    }


    class MoviesViewHolder(
        val recyclerviewMovieBinding:RecyclerviewMovieBinding
    ) :RecyclerView.ViewHolder(recyclerviewMovieBinding.root){

    }
}