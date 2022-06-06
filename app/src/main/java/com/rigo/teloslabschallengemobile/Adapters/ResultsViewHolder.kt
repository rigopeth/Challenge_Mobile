package com.rigo.teloslabschallengemobile.Adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rigo.teloslabschallengemobile.Models.Result
import com.rigo.teloslabschallengemobile.databinding.MovieCardBinding

class ResultsViewHolder (view : View ) : RecyclerView.ViewHolder(view) {
    private val binding = MovieCardBinding.bind(view)

    fun bindMovie(items: Result) {
        Glide.with(binding.moviePoster.context).load(items.image).into(binding.moviePoster)
        binding.movieTitle.text = items.title
    }
}