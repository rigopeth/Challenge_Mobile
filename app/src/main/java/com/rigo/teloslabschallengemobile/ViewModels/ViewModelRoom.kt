package com.rigo.teloslabschallengemobile.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.room.Room
import com.rigo.teloslabschallengemobile.Room.DBItems
import com.rigo.teloslabschallengemobile.Room.Favorites
import com.rigo.teloslabschallengemobile.Room.RentedMovies

class ViewModelRoom(val app : Application) : AndroidViewModel(app) {

    lateinit var allfavorites : MutableLiveData<List<Favorites>>
    lateinit var allRentedMovies: MutableLiveData<List<RentedMovies>>

    init {
        allfavorites = MutableLiveData()
        allRentedMovies = MutableLiveData()

        getAllFavorites()
        getAllRentedMovies()
    }

    fun getAllFavorites() {
        val favoritesDao = DBItems.getAppDataBase((getApplication()))?.daoFavorites()
        val list = favoritesDao?.getFavorites()
        allfavorites.postValue(list)
    }

    fun getAllFavoritesObservers(): MutableLiveData<List<Favorites>> {
        return allfavorites
    }

    fun insertUserFavorite(favorite: Favorites){
        val favoriteDao = DBItems.getAppDataBase((getApplication()))?.daoFavorites()
        favoriteDao?.setFavorite(favorite)
        getAllFavorites()
    }

    fun deleteUserFavorite(favorite: Favorites){
        val favoriteDao =  DBItems.getAppDataBase((getApplication()))?.daoFavorites()
        favoriteDao?.deleteFavorite(favorite)
        getAllFavorites()
    }

    /////////////RentedMovies

    fun getAllRentedMovies() {
        val rentedmoviesDao = DBItems.getAppDataBase((getApplication()))?.daoRentedMovies()
        val list = rentedmoviesDao?.getRentedMovies()
        allRentedMovies.postValue(list)
    }

    fun getAllRentedObservers(): MutableLiveData<List<RentedMovies>> {
        return allRentedMovies
    }

    fun inserRented(rentedMovies: RentedMovies){
        val rentedDao = DBItems.getAppDataBase((getApplication()))?.daoRentedMovies()
        rentedDao?.setRentedMovies(rentedMovies)
        getAllRentedMovies()
    }

    val selectedItem = MutableLiveData<String>()

    fun setItems(item: String){
        selectedItem.value = item
    }

    fun getItems(): LiveData<String>{

        return selectedItem

    }



}