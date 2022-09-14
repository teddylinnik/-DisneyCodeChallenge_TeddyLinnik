package com.example.disneycodechallenge_teddylinnik.reserved_guests

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.disneycodechallenge_teddylinnik.databinding.RowReservedGuestsViewHolderBinding

class ReservedGuestsAdapter(val reservedNames:List<String>?): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemBinding = RowReservedGuestsViewHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ReservedGuestsViewHolder(itemBinding)
    }
    override fun getItemCount(): Int {
        return reservedNames?.size ?: 0
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        reservedNames?.let {
            (holder as ReservedGuestsViewHolder).setData(reservedNames[position])    }
    }
}
