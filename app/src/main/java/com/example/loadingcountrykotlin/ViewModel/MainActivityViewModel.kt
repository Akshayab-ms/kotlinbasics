package com.example.loadingcountrykotlin.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.loadingcountrykotlin.Retrofit.ApiInterface
import com.example.loadingcountrykotlin.Retrofit.RetrofitInstance

import com.example.loadingcountrykotlin.data.CountryList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivityViewModel: ViewModel() {



lateinit var livedataList:MutableLiveData<List<CountryList>>
init {
    livedataList= MutableLiveData()
}
    fun getLivedataObserver():MutableLiveData<List<CountryList>>{
        return livedataList

    }
    fun makeApiCall(){


       val retrofitInstance= RetrofitInstance. getRetrofitInstance()
        val apiInterface=retrofitInstance.create(ApiInterface::class.java)
        val call=apiInterface.getCountryList()
        call.enqueue(object : Callback<List<CountryList>> {
            override fun onFailure(call: Call<List<CountryList>>, t: Throwable) {
              livedataList.postValue(null)
            }

            override fun onResponse(
                call: Call<List<CountryList>>,
                response: Response<List<CountryList>>
            ) {
                livedataList.postValue(response.body())
            }
        })
    }
}
