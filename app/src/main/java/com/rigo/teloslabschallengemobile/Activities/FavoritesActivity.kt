package com.rigo.teloslabschallengemobile.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.rigo.teloslabschallengemobile.Adapters.FavoritesAdapter
import com.rigo.teloslabschallengemobile.Room.Favorites
import com.rigo.teloslabschallengemobile.ViewModels.ViewModelRoom
import com.rigo.teloslabschallengemobile.databinding.ActivityFavoritesBinding

class FavoritesActivity : AppCompatActivity(),FavoritesAdapter.clickListener {

    private lateinit var binding : ActivityFavoritesBinding

    private lateinit var adapterFavorites : FavoritesAdapter
    private val listFavorites = mutableListOf<Favorites>()
    val viewModel : ViewModelRoom by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoritesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        initRecyclerView()
    }

    private fun initRecyclerView() {

        // val room = context?.let { Room.databaseBuilder(it, DBItems::class.java,"favorites").build() }

        adapterFavorites = FavoritesAdapter(listFavorites,this@FavoritesActivity)
        binding.recyclerViewFavorites.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        binding.recyclerViewFavorites.setHasFixedSize(true)
        binding.recyclerViewFavorites.adapter = adapterFavorites

        viewModel.getAllFavoritesObservers().observe(this,{
            listFavorites.clear()
            listFavorites.addAll(it)
            adapterFavorites.notifyDataSetChanged()
        })

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    override fun onDeleteUserClickListener(favorites: Favorites) {
       viewModel.deleteUserFavorite(favorites)
    }

    override fun onItemClickListener(favorites: Favorites) {
        TODO("Not yet implemented")
    }

}