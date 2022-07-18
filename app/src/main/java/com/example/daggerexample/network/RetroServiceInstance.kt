package com.example.daggerexample.network

import retrofit2.Call
import com.example.daggerexample.RecyclerList
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroServiceInstance {
    @GET("repositories")
    fun getDatafromApi(@Query("q")query: String):Call<RecyclerList>
}