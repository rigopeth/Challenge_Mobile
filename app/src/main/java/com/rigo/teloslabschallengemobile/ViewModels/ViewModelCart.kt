package com.rigo.teloslabschallengemobile.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rigo.teloslabschallengemobile.Models.Items

class ViewModelCart : ViewModel() {

    val selectedItems = MutableLiveData<List<Items>>()

    fun setItems(item: Items){
        selectedItems.value = selectedItems.value?.plus(item) ?: listOf(item)
    }

    fun getItems(): LiveData<List<Items>> {

        return selectedItems

    }

}