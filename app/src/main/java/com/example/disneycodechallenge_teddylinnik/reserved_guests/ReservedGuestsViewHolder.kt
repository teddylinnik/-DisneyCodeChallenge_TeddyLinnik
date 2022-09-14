package com.example.disneycodechallenge_teddylinnik.reserved_guests

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.disneycodechallenge_teddylinnik.databinding.RowReservedGuestsViewHolderBinding
import com.example.disneycodechallenge_teddylinnik.ui.MainActivity

class ReservedGuestsViewHolder(val binding: RowReservedGuestsViewHolderBinding):RecyclerView.ViewHolder(binding.root) {
    private var checked = false
    fun setData(name:String){
        Log.d("TheViewHolder","the nmae: ${name}")
        binding.guestNameTextView.text = name
        binding.guestNameTextView.contentDescription = name
        binding.checkBox.isChecked = checked
        binding.theMainLayout.setOnClickListener {
            binding.checkBox.isChecked = !binding.checkBox.isChecked
        }
        binding.checkBox.setOnCheckedChangeListener { compoundButton, b ->
            checked = b
            val mainActivity = binding.root.context as MainActivity
            if(checked){
                ++mainActivity.reservedPeopleCounter
            }
            else
            {
                --mainActivity.reservedPeopleCounter
            }
            mainActivity.checkEnableContinueButton()
        }
    }
}