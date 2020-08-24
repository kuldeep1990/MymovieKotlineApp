package com.mymovieappkot.modelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mymovieappkot.repository.MoviesRepository
import com.mymovieappkot.viewModel.MoviesViewModel

class MoviesViewModelFactory (
    private val repository: MoviesRepository
):ViewModelProvider.NewInstanceFactory(){

    override fun <T: ViewModel?>create(modelClass:Class<T>):T{
        return MoviesViewModel(repository) as T
    }
}