package com.mymovieappkot.repository

import com.mymovieappkot.remote.MoviesApi
import com.mymovieappkot.remote.SafeApiRequest

class MoviesRepository (
    private val api: MoviesApi
): SafeApiRequest(){
    suspend fun getMovies()=apiRequest {api.getMovies()  }
}