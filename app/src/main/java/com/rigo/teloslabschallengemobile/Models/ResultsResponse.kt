package com.rigo.teloslabschallengemobile.Models

data class ResultsResponse(
    val errorMessage: String,
    val expression: String,
    val results: List<Result>,
    val searchType: String
)