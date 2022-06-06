package com.rigo.teloslabschallengemobile.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Favorites::class,RentedMovies::class],version = 1)
abstract class DBItems : RoomDatabase() {

    abstract fun daoFavorites():DAOFavorites?

    abstract fun daoRentedMovies():DAORentendMovies?

    companion object {
        private var INSTANCE : DBItems? = null

        fun getAppDataBase(context: Context): DBItems? {
            if(INSTANCE==null){
                INSTANCE = Room.databaseBuilder<DBItems>(
                    context.applicationContext,DBItems::class.java,"AppDB"
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE
        }

    }



}