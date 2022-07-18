package com.example.daggerexample.network

import android.util.Log
import retrofit2.Call
import androidx.lifecycle.MutableLiveData
import com.example.daggerexample.RecycleData
import com.example.daggerexample.RecyclerList
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Query
import javax.inject.Inject

class RetroRepository @Inject constructor(private val retroInstance: RetroServiceInstance)  {

    fun makeApiCall(query: String, liveDataList: MutableLiveData<List<RecycleData>>) {
        val call: Call<RecyclerList> = retroInstance.getDatafromApi(query)
        call.enqueue(object : Callback<RecyclerList>{
            override fun onFailure(call: Call<RecyclerList>, t: Throwable) {
                liveDataList.postValue(null)
                Log.d("response",t.message.toString())
            }

            override fun onResponse(call: Call<RecyclerList>, response: Response<RecyclerList>) {
                liveDataList.postValue(response.body()?.items!!)
                Log.d("response",response.body()?.items!!.toString())

            }
        })

    }
}