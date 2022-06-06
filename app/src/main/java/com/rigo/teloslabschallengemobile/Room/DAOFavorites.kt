package com.rigo.teloslabschallengemobile.Room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DAOFavorites {

    @Query("SELECT * FROM favorites")
    fun getFavorites(): List<Favorites>

    @Insert
    fun setFavorite(favorite:Favorites)

    @Delete
    fun deleteFavorite(favorite: Favorites?)
}