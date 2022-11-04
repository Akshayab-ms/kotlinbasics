package com.example.loadingcountrykotlin.Retrofit

import com.example.loadingcountrykotlin.data.CountryList
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("v2")
    fun getCountryList(): Call<List<CountryList>>


}