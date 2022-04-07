package com.example.kotlinexample2.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinexample2.model.CountryListModel
import com.example.kotlinexample2.network.RetroInstance
import com.example.kotlinexample2.network.RetroInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel : ViewModel() {

    lateinit var liveDataList : MutableLiveData<List<CountryListModel>>

    init {
        liveDataList = MutableLiveData()
    }

    fun getLiveDataObserver() : MutableLiveData<List<CountryListModel>> {
        return liveDataList
    }

    fun makeApiCall(){
        val retroInstance = RetroInstance.getRetroInstance()
        val retroService = retroInstance.create(RetroInterface::class.java)
        val call = retroService.getCountryList()
        call.enqueue(object : Callback<List<CountryListModel>> {

            override fun onResponse(
                call: Call<List<CountryListModel>>,
                response: Response<List<CountryListModel>>
            ) {
                liveDataList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<CountryListModel>>, t: Throwable) {
                liveDataList.postValue(null)
            }

        })
    }

}