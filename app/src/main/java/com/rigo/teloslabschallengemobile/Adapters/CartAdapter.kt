package com.rigo.teloslabschallengemobile.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rigo.teloslabschallengemobile.Models.Items
import com.rigo.teloslabschallengemobile.R

class CartAdapter (private var items : List<Items>) : RecyclerView.Adapter<CartViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CartViewHolder(layoutInflater.inflate(R.layout.movie_card,parent,false))
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bindMovie(items[position])
    }

    override fun getItemCount(): Int= items.size

}