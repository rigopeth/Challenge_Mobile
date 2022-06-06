package com.rigo.teloslabschallengemobile.Room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DAORentendMovies {

    @Query("SELECT * FROM rented_movies")
    fun getRentedMovies(): List<RentedMovies>

    @Insert
    fun setRentedMovies(rentedMovies:RentedMovies)
}