package com.rigo.teloslabschallengemobile.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rigo.teloslabschallengemobile.R
import com.rigo.teloslabschallengemobile.Room.RentedMovies

class RentedItemsAdapter(private val items : List<RentedMovies> ) :RecyclerView.Adapter<RentedItemsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RentedItemsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return RentedItemsViewHolder(layoutInflater.inflate(R.layout.movie_card,parent,false))
    }

    override fun onBindViewHolder(holder: RentedItemsViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}