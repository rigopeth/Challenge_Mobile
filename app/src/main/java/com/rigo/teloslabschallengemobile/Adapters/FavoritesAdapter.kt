package com.rigo.teloslabschallengemobile.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rigo.teloslabschallengemobile.R
import com.rigo.teloslabschallengemobile.Room.Favorites

class FavoritesAdapter(private var items: List<Favorites>,val listener : clickListener) : RecyclerView.Adapter<FavoritesViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return FavoritesViewHolder(layoutInflater.inflate(R.layout.item_card_favorites,parent,false),listener)
    }

    override fun onBindViewHolder(holder: FavoritesViewHolder, position: Int) {
        holder.bindFavorites(items[position])
    }

    override fun getItemCount(): Int = items.size

    interface clickListener{
        fun onDeleteUserClickListener(favorites: Favorites)
        fun onItemClickListener(favorites: Favorites)
    }
}