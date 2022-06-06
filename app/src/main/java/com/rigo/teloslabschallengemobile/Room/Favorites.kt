package com.rigo.teloslabschallengemobile.Room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorites")
data class Favorites (
    @PrimaryKey(autoGenerate = true) val id : Int =0,
    val iditem:String? = null,
    val title:String? = null,
    val image:String? = null
        )