package com.example.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.firstapp.Classes.Car
import com.example.firstapp.Classes.Port
import com.example.firstapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initialView()

    }

    private fun initialView() {

        binding!!.btnAge.setOnClickListener {
            var inten = Intent(this, CalculeAge::class.java)
            startActivity(inten)
        }

        binding!!.btnTicTakToy.setOnClickListener {
            var inten = Intent(this, TicTacToy::class.java)
            startActivity(inten)
        }


    }
}