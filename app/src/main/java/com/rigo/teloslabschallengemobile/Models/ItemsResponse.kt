package com.rigo.teloslabschallengemobile.Models

import com.google.gson.annotations.SerializedName

data class ItemsResponse(
    val errorMessage: String,
    @SerializedName("items") val items: List<Items>
)