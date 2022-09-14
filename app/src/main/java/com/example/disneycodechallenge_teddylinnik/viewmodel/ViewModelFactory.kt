package com.example.disneycodechallenge_teddylinnik.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.disneycodechallenge_teddylinnik.repository.MainRepository

class ViewModelFactory(val rep:MainRepository) :ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainActivityViewModel(rep) as T
    }
}