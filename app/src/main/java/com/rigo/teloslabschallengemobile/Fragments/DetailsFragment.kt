package com.rigo.teloslabschallengemobile.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.rigo.teloslabschallengemobile.Models.Items
import com.rigo.teloslabschallengemobile.R
import com.rigo.teloslabschallengemobile.Room.Favorites
import com.rigo.teloslabschallengemobile.ViewModels.ViewModelCart
import com.rigo.teloslabschallengemobile.ViewModels.ViewModelRoom
import com.rigo.teloslabschallengemobile.ViewModels.ViewModelDetails
import com.rigo.teloslabschallengemobile.databinding.FragmentDetailsBinding


class DetailsFragment : Fragment() {

    val viewModel : ViewModelDetails by activityViewModels()
    val viewModelFavorites : ViewModelRoom by activityViewModels()
    val viewModelCart : ViewModelCart by activityViewModels()

    private var _binding : FragmentDetailsBinding?= null
    private val binding get() = _binding!!



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetailsBinding.inflate(inflater,container,false)

        var id = ""
        var title = ""
        var image = ""
        var item : Items? = null

        viewModel.getItems().observe(viewLifecycleOwner, Observer {
            binding.title.text = "Title: ${it.fullTitle}"
            binding.crew.text = "Crew: ${it.crew}"
            binding.year.text = "Year: ${it.year}"
            Glide.with(binding.imageView.context).load(it.image).into(binding.imageView)
            id = it.id
            title = it.title
            image = it.image
            item = it
        })

        binding.add.setOnClickListener {
            val favorite = Favorites(0,id,title,image)
            viewModelFavorites.insertUserFavorite(favorite)
            Toast.makeText(activity,"You add $title to your Favorites",Toast.LENGTH_SHORT).show()
        }

        binding.addCart.setOnClickListener {
            viewModelCart.setItems(item!!)
            Toast.makeText(activity,"You add $title to the Car",Toast.LENGTH_SHORT).show()
        }

        binding.backButton.setOnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragmentLayout, HomeFragment())
            transaction?.disallowAddToBackStack()
            transaction?.commit()
        }

        return binding.root
    }

}