package com.rigo.teloslabschallengemobile.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rigo.teloslabschallengemobile.Models.Items

class ViewModelDetails: ViewModel() {

    val selectedItem = MutableLiveData<Items>()

    fun setItems(item: Items){
        selectedItem.value = item
    }

    fun getItems(): LiveData<Items> {

        return selectedItem

    }

}