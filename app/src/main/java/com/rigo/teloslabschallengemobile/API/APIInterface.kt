package com.rigo.teloslabschallengemobile.API

import com.rigo.teloslabschallengemobile.Models.ItemsResponse
import com.rigo.teloslabschallengemobile.Models.ResultsResponse
import com.rigo.teloslabschallengemobile.Utils.Constants
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIInterface {

    @GET(Constants.POPULAR_MOVIES)
    fun getPopularMovies(@Query("apiKey") apiKey : String) : Call<ItemsResponse>

    @GET(Constants.POPULAR_TV_SHOWS)
    fun getPopularTvShows(@Query("apiKey") apiKey : String) : Call<ItemsResponse>

    @GET(Constants.SEARCH_MOVIE)
    fun getSearchMovie(@Query("apiKey") apiKey : String, @Query("expression") expression : String) : Call<ResultsResponse>

    @GET(Constants.SEARCH_SERIE)
    fun getSearchSerie(@Query("apiKey") apiKey : String, @Query("expression") expression : String) : Call<ResultsResponse>

}