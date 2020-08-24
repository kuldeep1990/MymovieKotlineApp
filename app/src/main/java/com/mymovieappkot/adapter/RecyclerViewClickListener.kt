package com.mymovieappkot.adapter

import android.view.View
import com.mymovieappkot.model.Movies

interface RecyclerViewClickListener {
    fun onRecyclerViewItemClick(view: View, movie: Movies)
}