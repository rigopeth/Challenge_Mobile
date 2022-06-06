package com.rigo.teloslabschallengemobile.Adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rigo.teloslabschallengemobile.Models.Items
import com.rigo.teloslabschallengemobile.databinding.MovieCardBinding

class CartViewHolder(view :View) : RecyclerView.ViewHolder(view) {

    private val binding = MovieCardBinding.bind(view)

    fun bindMovie(items: Items) {
        Glide.with(binding.moviePoster.context).load(items.image).into(binding.moviePoster)
        binding.movieTitle.text = items.title
        /*binding.moviePoster.setOnClickListener {

            /*val intent = Intent(view.context, DetailsActivity::class.java)
            intent.putExtra("id",items.id)
            intent.putExtra("title",items.title)
            intent.putExtra("image",items.image)
            view.context.startActivity(intent)*/

        }*/
    }
}