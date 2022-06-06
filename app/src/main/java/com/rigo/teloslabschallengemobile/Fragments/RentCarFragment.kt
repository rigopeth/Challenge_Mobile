package com.rigo.teloslabschallengemobile.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.rigo.teloslabschallengemobile.API.APIInterface
import com.rigo.teloslabschallengemobile.API.APIService
import com.rigo.teloslabschallengemobile.Adapters.CartAdapter
import com.rigo.teloslabschallengemobile.Adapters.ItemsAdapter
import com.rigo.teloslabschallengemobile.Models.Items
import com.rigo.teloslabschallengemobile.Models.ItemsResponse
import com.rigo.teloslabschallengemobile.Room.RentedMovies
import com.rigo.teloslabschallengemobile.Utils.Constants
import com.rigo.teloslabschallengemobile.ViewModels.ViewModelCart
import com.rigo.teloslabschallengemobile.ViewModels.ViewModelDetails
import com.rigo.teloslabschallengemobile.ViewModels.ViewModelRoom
import com.rigo.teloslabschallengemobile.databinding.FragmentRentCarBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RentCarFragment : Fragment() {

    companion object {
        fun newInstance(): RentCarFragment = RentCarFragment()
    }

    val viewModelCart : ViewModelCart by activityViewModels()
    val viewModelRoom : ViewModelRoom by activityViewModels()

    private lateinit var adapterItems : CartAdapter
    private val listitems = mutableListOf<Items>()

    private var _binding : FragmentRentCarBinding?=null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRentCarBinding.inflate(inflater,container,false)

        adapterItems = CartAdapter(listitems)
        binding.recyclerViewAddCart.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL,false)
        binding.recyclerViewAddCart.setHasFixedSize(true)
        binding.recyclerViewAddCart.adapter = adapterItems

        var listRoom : List<Items>? = null

        viewModelCart.getItems().observe(viewLifecycleOwner,{
            listitems.clear()
            listitems.addAll(it)
            listRoom=it
            adapterItems.notifyDataSetChanged()
        })

        binding.rentButton.setOnClickListener {
            listRoom?.forEach {
                val rentMovie = RentedMovies(0,it.id,it.title,it.image)
                viewModelRoom.inserRented(rentMovie)
                viewModelRoom.getAllRentedObservers().observe(viewLifecycleOwner,{
                    for (item in it){
                        println("${item.iditem}, ${item.image}, ${item.title}")
                    }
                })
            }

            Toast.makeText(activity,"You has rent this Films",Toast.LENGTH_SHORT).show()
        }


        return binding.root
    }




}