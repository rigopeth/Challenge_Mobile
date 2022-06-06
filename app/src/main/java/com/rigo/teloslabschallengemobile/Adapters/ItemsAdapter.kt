package com.rigo.teloslabschallengemobile.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rigo.teloslabschallengemobile.Models.Items
import com.rigo.teloslabschallengemobile.R

class ItemsAdapter (private var items : List<Items>,val listener : clickListenerItems) : RecyclerView.Adapter<ItemsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ItemsViewHolder(layoutInflater.inflate(R.layout.movie_card,parent,false),listener!!)
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            listener.onItemClickListener(items[position])
        }
        holder.bindMovie(items[position])

    }

    override fun getItemCount(): Int = items.size

    interface clickListenerItems{
        fun onDeleteUserClickListener(item: Items)
        fun onItemClickListener(item: Items)
    }

}