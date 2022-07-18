package com.example.daggerexample

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.daggerexample.network.RetroRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModdel @Inject constructor(private val repository: RetroRepository) :ViewModel(){

    var liveDataList:MutableLiveData<List<RecycleData>>
    init {
        liveDataList= MutableLiveData()
    }
    fun loadListofDaat(search :String){
        Log.d("response","LoadData")
        repository.makeApiCall(search,liveDataList)
    }

}