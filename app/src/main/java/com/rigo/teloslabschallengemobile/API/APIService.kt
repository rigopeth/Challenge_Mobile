package com.rigo.teloslabschallengemobile.API

import com.rigo.teloslabschallengemobile.Utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIService {

    companion object {

        private var retrofit : Retrofit? = null

        fun getInstance() : Retrofit {
            if(retrofit==null){
                retrofit = Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }

    }

}