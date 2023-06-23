package com.example.jokeapp.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ChuckNorrisAPI {

    @GET("jokes/categories")
    fun findAllcategories(@Query("apiKey") apiKey: String = HTTPClient.API_KEY) : Call<List<String>>

}