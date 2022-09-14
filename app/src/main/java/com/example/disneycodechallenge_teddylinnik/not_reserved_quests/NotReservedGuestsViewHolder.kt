package com.example.disneycodechallenge_teddylinnik.not_reserved_quests

import androidx.recyclerview.widget.RecyclerView
import com.example.disneycodechallenge_teddylinnik.databinding.RowNotReservedGuestsViewHolderBinding
import com.example.disneycodechallenge_teddylinnik.ui.MainActivity

class NotReservedGuestsViewHolder (val binding: RowNotReservedGuestsViewHolderBinding): RecyclerView.ViewHolder(binding.root) {
    private var checked = false
    fun setData(name:String){
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
                ++mainActivity.notReservedPeopleCounter
            }
            else
            {
                --mainActivity.notReservedPeopleCounter
            }
            mainActivity.checkEnableContinueButton()
        }

    }
}