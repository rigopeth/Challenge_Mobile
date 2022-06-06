package com.rigo.teloslabschallengemobile.Adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rigo.teloslabschallengemobile.Room.RentedMovies
import com.rigo.teloslabschallengemobile.databinding.MovieCardBinding

class RentedItemsViewHolder(view:View) : RecyclerView.ViewHolder(view) {

    private val binding = MovieCardBinding.bind(view)

    fun bind(items: RentedMovies) {
        Glide.with(binding.moviePoster.context).load(items.image).into(binding.moviePoster)
        binding.movieTitle.text = items.title
    }
}