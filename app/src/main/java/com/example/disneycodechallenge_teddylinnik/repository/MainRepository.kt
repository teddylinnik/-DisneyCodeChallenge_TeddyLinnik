package com.example.disneycodechallenge_teddylinnik.repository

import com.example.disneycodechallenge_teddylinnik.data.ReceivedData
import com.google.gson.Gson

class MainRepository {
    suspend fun getNames(jsonString:String):ReceivedData{
       return  Gson().fromJson(jsonString, ReceivedData::class.java)
    }
}