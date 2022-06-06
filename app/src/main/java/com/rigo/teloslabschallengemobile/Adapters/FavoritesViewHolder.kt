package com.rigo.teloslabschallengemobile.Adapters


import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rigo.teloslabschallengemobile.Room.Favorites
import com.rigo.teloslabschallengemobile.databinding.ItemCardFavoritesBinding

class FavoritesViewHolder(view:View ,val  listener : FavoritesAdapter.clickListener) :RecyclerView.ViewHolder(view) {

    private val binding = ItemCardFavoritesBinding.bind(view)

    fun bindFavorites(items: Favorites) {
        Glide.with(binding.moviePoster.context).load(items.image).into(binding.moviePoster)
        binding.movieTitle.text = items.title
        binding.delete.setOnClickListener {
            listener.onDeleteUserClickListener(items)
        }
    }

}