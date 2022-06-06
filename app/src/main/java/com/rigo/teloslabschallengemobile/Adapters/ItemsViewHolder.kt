package com.rigo.teloslabschallengemobile.Adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rigo.teloslabschallengemobile.Models.Items
import com.rigo.teloslabschallengemobile.databinding.MovieCardBinding

class ItemsViewHolder(view:View,val listener : ItemsAdapter.clickListenerItems) : RecyclerView.ViewHolder(view) {

    private val binding = MovieCardBinding.bind(view)

    fun bindMovie(items: Items) {
        Glide.with(binding.moviePoster.context).load(items.image).into(binding.moviePoster)
        binding.movieTitle.text = items.title
    }


}