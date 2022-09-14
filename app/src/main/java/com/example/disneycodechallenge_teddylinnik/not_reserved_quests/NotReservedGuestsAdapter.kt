package com.example.disneycodechallenge_teddylinnik.not_reserved_quests

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.disneycodechallenge_teddylinnik.databinding.RowNotReservedGuestsViewHolderBinding

class NotReservedGuestsAdapter(val notReservedNames:List<String>?): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemBinding = RowNotReservedGuestsViewHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NotReservedGuestsViewHolder(itemBinding)
    }
    override fun getItemCount(): Int {
        return notReservedNames?.size ?: 0
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        notReservedNames?.let {
            (holder as NotReservedGuestsViewHolder).setData(notReservedNames[position])    }
    }
}
