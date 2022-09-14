package com.example.disneycodechallenge_teddylinnik.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.disneycodechallenge_teddylinnik.data.ReceivedData
import com.example.disneycodechallenge_teddylinnik.repository.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class MainActivityViewModel(val repository: MainRepository): ViewModel() {


    val successResponse = MutableLiveData<ReceivedData>()
    val failedRespponse = MutableLiveData<String>()

    fun getNames(jsonString:String){
        viewModelScope.launch(Dispatchers.IO) {
            try{
                val res = repository.getNames(jsonString)
                if(res.success){
                    successResponse.postValue(res)
                }
                else
                {
                    failedRespponse.postValue("Failed call")
                }
            }
            catch (e:Exception){
                failedRespponse.postValue("Exception: ${e.message}")
            }
        }
    }

}