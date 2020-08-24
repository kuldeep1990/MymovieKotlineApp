package com.mymovieappkot.view

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.mymovieappkot.viewModel.MoviesViewModel
import com.mymovieappkot.modelfactory.MoviesViewModelFactory
import com.mymovieappkot.R
import com.mymovieappkot.adapter.MoviesAdapter
import com.mymovieappkot.remote.MoviesApi
import com.mymovieappkot.repository.MoviesRepository
import kotlinx.android.synthetic.main.movies_fragment.*

class MoviesFragment : Fragment() {

    companion object {
        fun newInstance() = MoviesFragment()
    }
    private lateinit var factory: MoviesViewModelFactory
    private lateinit var viewModel: MoviesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movies_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val api = MoviesApi()
        val repository= MoviesRepository(api)
        factory=
            MoviesViewModelFactory(repository)
        viewModel = ViewModelProviders.of(this,factory).get(MoviesViewModel::class.java)
        viewModel.getMovies()
        viewModel.movies.observe(viewLifecycleOwner, Observer { movies-> recycler_view_movies.also {
            it.layoutManager=LinearLayoutManager(requireContext())
            it.setHasFixedSize(true)
            it.adapter= MoviesAdapter(movies)
        }})

    }

}