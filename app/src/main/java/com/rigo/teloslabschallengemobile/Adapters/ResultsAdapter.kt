package com.rigo.teloslabschallengemobile.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rigo.teloslabschallengemobile.Models.Result
import com.rigo.teloslabschallengemobile.R

class ResultsAdapter(private val result : List<Result>) : RecyclerView.Adapter<ResultsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultsViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        return ResultsViewHolder(layoutInflater.inflate(R.layout.movie_card,parent,false))
    }

    override fun onBindViewHolder(holder: ResultsViewHolder, position: Int) {

        holder.bindMovie(result[position])
    }

    override fun getItemCount(): Int = result.size


}