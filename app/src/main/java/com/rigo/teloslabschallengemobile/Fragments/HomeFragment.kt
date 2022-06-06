package com.rigo.teloslabschallengemobile.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.rigo.teloslabschallengemobile.API.APIInterface
import com.rigo.teloslabschallengemobile.API.APIService
import com.rigo.teloslabschallengemobile.Activities.FavoritesActivity
import com.rigo.teloslabschallengemobile.Activities.RentedItems
import com.rigo.teloslabschallengemobile.Adapters.ItemsAdapter
import com.rigo.teloslabschallengemobile.Models.Items
import com.rigo.teloslabschallengemobile.Models.ItemsResponse
import com.rigo.teloslabschallengemobile.Utils.Constants
import com.rigo.teloslabschallengemobile.R
import com.rigo.teloslabschallengemobile.ViewModels.ViewModelDetails
import com.rigo.teloslabschallengemobile.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment(),ItemsAdapter.clickListenerItems {

    companion object {
        fun newInstance(): HomeFragment = HomeFragment()
    }

    private var _binding : FragmentHomeBinding? = null
    private val binding get() =_binding!!
    private lateinit var adapterMovies : ItemsAdapter
    private lateinit var adapterTvshows : ItemsAdapter
    private val listMovies = mutableListOf<Items>()
    private val listTvShows = mutableListOf<Items>()
    val viewModel : ViewModelDetails by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater,container,false)

        initRecyclerViews()

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.myrented.setOnClickListener {
            val intent = Intent(activity, RentedItems::class.java)
            startActivity(intent)
        }

        binding.myFavorites.setOnClickListener {
            val intent = Intent(activity, FavoritesActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initRecyclerViews() {

        adapterMovies = ItemsAdapter(listMovies,this)
        binding.recyclerViewPopularMovies.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL,false)
        binding.recyclerViewPopularMovies.setHasFixedSize(true)
        binding.recyclerViewPopularMovies.adapter = adapterMovies

        adapterTvshows = ItemsAdapter(listTvShows,this)
        binding.recyclerViewTvShows.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
        binding.recyclerViewTvShows.setHasFixedSize(true)
        binding.recyclerViewTvShows.adapter = adapterTvshows

        getMovieData { movies : List<Items> ->
            listMovies.addAll(movies)
            adapterMovies.notifyDataSetChanged()
        }

        getTvShowsData { tvShows : List<Items> ->
            listTvShows.addAll(tvShows)
            adapterTvshows.notifyDataSetChanged()
        }

    }

    private fun getMovieData ( callback : (List<Items>) -> Unit) {
        val apiService = APIService.getInstance().create(APIInterface::class.java)
        apiService.getPopularMovies(Constants.API_KEY).enqueue(object : Callback<ItemsResponse> {
            override fun onResponse(
                call: Call<ItemsResponse>,
                response: Response<ItemsResponse>
            ) {
                return callback(response.body()!!.items)
            }

            override fun onFailure(call: Call<ItemsResponse>, t: Throwable) {

            }

        })
    }

    private fun getTvShowsData ( callback : (List<Items>) -> Unit) {
        val apiService = APIService.getInstance().create(APIInterface::class.java)
        apiService.getPopularTvShows(Constants.API_KEY).enqueue(object : Callback<ItemsResponse> {
            override fun onResponse(
                call: Call<ItemsResponse>,
                response: Response<ItemsResponse>
            ) {
                return callback(response.body()!!.items)
            }

            override fun onFailure(call: Call<ItemsResponse>, t: Throwable) {

            }

        })
    }

    override fun onDeleteUserClickListener(item: Items) {
    }

    override fun onItemClickListener(item: Items) {
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction?.replace(R.id.fragmentLayout, DetailsFragment())
        transaction?.disallowAddToBackStack()
        transaction?.commit()
        viewModel.setItems(item)
    }

}