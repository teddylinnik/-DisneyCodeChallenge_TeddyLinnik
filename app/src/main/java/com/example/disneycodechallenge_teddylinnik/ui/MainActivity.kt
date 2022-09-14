package com.example.disneycodechallenge_teddylinnik.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.disneycodechallenge_teddylinnik.R
import com.example.disneycodechallenge_teddylinnik.data.ReceivedData
import com.example.disneycodechallenge_teddylinnik.databinding.ActivityMainBinding
import com.example.disneycodechallenge_teddylinnik.not_reserved_quests.NotReservedGuestsAdapter
import com.example.disneycodechallenge_teddylinnik.repository.MainRepository
import com.example.disneycodechallenge_teddylinnik.reserved_guests.ReservedGuestsAdapter
import com.example.disneycodechallenge_teddylinnik.viewmodel.MainActivityViewModel
import com.example.disneycodechallenge_teddylinnik.viewmodel.ViewModelFactory
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var viewmodel:MainActivityViewModel
    var reservedPeopleCounter = 0
    var notReservedPeopleCounter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        viewmodel = ViewModelProvider(this,ViewModelFactory(MainRepository())).get(MainActivityViewModel::class.java)
        setContentView(binding.root)
        initToolbar()
        setButtonListener()
        getNames()
    }


    private fun getNames(){
        val objectArrayString: String = applicationContext.resources.openRawResource(R.raw.names).bufferedReader().use { it.readText() }
        viewmodel.successResponse.observe(this){
            setRecyclerView(it)
        }
        viewmodel.failedRespponse.observe(this){
            Toast.makeText(this,it,Toast.LENGTH_LONG).show()
        }
        viewmodel.getNames(objectArrayString)
    }



    private fun initToolbar(){
        val toolbar=binding.toolbar

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false);


        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_baseline_arrow_back_ios_new_24));

        toolbar.setNavigationOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                onBackPressed()
            }
        })
    }

    private fun setButtonListener(){
        binding.btnContinue.setOnClickListener {
            if(reservedPeopleCounter>0){
                val intent = Intent(this,ReservedActivity::class.java)
                startActivity(intent)
            }
            else{
                setDialogAlert()
            }
        }
    }

    private fun setDialogAlert(){
        val dialog = BottomSheetDialog(this)
        dialog.getWindow()?.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
        val view = layoutInflater.inflate(R.layout.dialog_alert, null)
        val btnClose = view.findViewById<ImageView>(R.id.image_close)
        btnClose.setOnClickListener {
            dialog.dismiss()
        }
        dialog.setCancelable(false)
        dialog.setContentView(view)
        dialog.show()
    }


    private fun setRecyclerView(name:ReceivedData){
        val reservedAdapted = ReservedGuestsAdapter(name.reservedNameList)
        binding.myRecyclerViewReserved.adapter = reservedAdapted
        binding.myRecyclerViewReserved.layoutManager = LinearLayoutManager(this)
        val notReservedAdapted = NotReservedGuestsAdapter(name.notReservedNameList)
        binding.myRecyclerViewNotReserved.adapter = notReservedAdapted
        binding.myRecyclerViewNotReserved.layoutManager = LinearLayoutManager(this)
    }


    fun checkEnableContinueButton(){
        binding.btnContinue.isEnabled = (reservedPeopleCounter+ notReservedPeopleCounter >0)
    }

}