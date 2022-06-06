package com.rigo.teloslabschallengemobile.Fragments

import android.opengl.Visibility
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.rigo.teloslabschallengemobile.API.APIInterface
import com.rigo.teloslabschallengemobile.API.APIService
import com.rigo.teloslabschallengemobile.Adapters.ItemsAdapter
import com.rigo.teloslabschallengemobile.Adapters.ResultsAdapter
import com.rigo.teloslabschallengemobile.Models.Items
import com.rigo.teloslabschallengemobile.Models.ItemsResponse
import com.rigo.teloslabschallengemobile.Models.Result
import com.rigo.teloslabschallengemobile.Models.ResultsResponse
import com.rigo.teloslabschallengemobile.R
import com.rigo.teloslabschallengemobile.Utils.Constants
import com.rigo.teloslabschallengemobile.ViewModels.ViewModelDetails
import com.rigo.teloslabschallengemobile.databinding.FragmentSearchBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SearchFragment : Fragment(),SearchView.OnQueryTextListener {
    companion object {
        fun newInstance(): SearchFragment = SearchFragment()
    }

    private var _binding :FragmentSearchBinding?= null
    private val binding get() = _binding!!
    private lateinit var adapterResultsMovies : ResultsAdapter
    private val listResultsMovies = mutableListOf<Result>()
    private lateinit var adapterResultsTvShows : ResultsAdapter
    private val listResultsTvshows = mutableListOf<Result>()
    var expression = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSearchBinding.inflate(inflater,container,false)
        initRecyclerViews()
        binding.viewSearch.setOnQueryTextListener(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private fun initRecyclerViews() {

        adapterResultsMovies = ResultsAdapter(listResultsMovies)
        binding.recyclerViewSearch.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL,false)
        binding.recyclerViewSearch.setHasFixedSize(true)
        binding.recyclerViewSearch.adapter = adapterResultsMovies

        adapterResultsTvShows = ResultsAdapter(listResultsTvshows)
        binding.recyclerViewSearchTvShows.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL,false)
        binding.recyclerViewSearchTvShows.setHasFixedSize(true)
        binding.recyclerViewSearchTvShows.adapter = adapterResultsTvShows


    }

    private fun getSearchMovie ( callback : (List<Result>) -> Unit) {
        val apiService = APIService.getInstance().create(APIInterface::class.java)
        apiService.getSearchMovie(Constants.API_KEY,expression).enqueue(object : Callback<ResultsResponse> {
            override fun onResponse(
                call: Call<ResultsResponse>,
                response: Response<ResultsResponse>
            ) {
                return callback(response.body()!!.results)
            }

            override fun onFailure(call: Call<ResultsResponse>, t: Throwable) {

            }

        })
    }

    private fun getSearchTvShows ( callback : (List<Result>) -> Unit) {
        val apiService = APIService.getInstance().create(APIInterface::class.java)
        apiService.getSearchSerie(Constants.API_KEY,expression).enqueue(object : Callback<ResultsResponse> {
            override fun onResponse(
                call: Call<ResultsResponse>,
                response: Response<ResultsResponse>
            ) {
                return callback(response.body()!!.results)
            }

            override fun onFailure(call: Call<ResultsResponse>, t: Throwable) {

            }

        })
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if (!query.isNullOrEmpty()){
            expression = query.lowercase()
            binding.textResultMovie.visibility = View.VISIBLE
            binding.textResultTvshows.visibility = View.VISIBLE
            getSearchMovie { results : List<Result> ->
                listResultsMovies.clear()
                listResultsMovies.addAll(results)
                adapterResultsMovies.notifyDataSetChanged()
            }

            getSearchTvShows { results : List<Result> ->
                listResultsTvshows.clear()
                listResultsTvshows.addAll(results)
                adapterResultsTvShows.notifyDataSetChanged()
            }
        }
        return true
    }

    override fun onQueryTextChange(p0: String?): Boolean {
        return true
    }


}