package com.mymovieappkot.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mymovieappkot.Coroutines
import com.mymovieappkot.model.Movies
import com.mymovieappkot.repository.MoviesRepository
import kotlinx.coroutines.Job

class MoviesViewModel(
    private val repository: MoviesRepository
) : ViewModel() {

    private lateinit var job:Job
    private val _movies = MutableLiveData<List<Movies>>()
    val movies : LiveData<List<Movies>>
    get() = _movies

     fun getMovies(){
//        val movies = repository.getMovies()
//        _movies.value=movies
        job= Coroutines.ioThenMain(
            { repository.getMovies() },
            {
                _movies.value = it
            }
        )

    }

    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized)
            job.cancel()
    }
}