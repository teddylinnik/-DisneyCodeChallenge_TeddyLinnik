package com.example.disneycodechallenge_teddylinnik.data

import com.google.gson.annotations.SerializedName

data class ReceivedData(
    @SerializedName("notReservedNameList")
    val notReservedNameList: List<String>,
    @SerializedName("reservedNameList")
    val reservedNameList: List<String>,
    @SerializedName("success")
    val success: Boolean
)