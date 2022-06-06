package com.rigo.teloslabschallengemobile.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.rigo.teloslabschallengemobile.Adapters.FavoritesAdapter
import com.rigo.teloslabschallengemobile.Adapters.RentedItemsAdapter
import com.rigo.teloslabschallengemobile.R
import com.rigo.teloslabschallengemobile.Room.RentedMovies
import com.rigo.teloslabschallengemobile.ViewModels.ViewModelRoom
import com.rigo.teloslabschallengemobile.databinding.ActivityRentedItemsBinding

class RentedItems : AppCompatActivity() {

    private lateinit var binding: ActivityRentedItemsBinding

    private lateinit var adapterRentedItems : RentedItemsAdapter
    private val listRentedItems = mutableListOf<RentedMovies>()
    val viewModel : ViewModelRoom by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRentedItemsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        initRecyclerView()

    }

    private fun initRecyclerView() {

        adapterRentedItems = RentedItemsAdapter(listRentedItems)
        binding.recyclerViewRented.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        binding.recyclerViewRented.setHasFixedSize(true)
        binding.recyclerViewRented.adapter = adapterRentedItems

        viewModel.getAllRentedObservers().observe(this,{
            listRentedItems.clear()
            listRentedItems.addAll(it)
            adapterRentedItems.notifyDataSetChanged()
        })

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

}