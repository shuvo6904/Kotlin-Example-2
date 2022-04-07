package com.example.kotlinexample2.network

import com.example.kotlinexample2.model.CountryListModel
import retrofit2.Call
import retrofit2.http.GET

interface RetroInterface {

    @GET("v3.1/all")
    fun getCountryList() : Call<List<CountryListModel>>
}